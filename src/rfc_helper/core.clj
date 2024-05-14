(ns rfc-helper.core
  (:require
    [clojure.string :as string]
    [cheshire.core :as json]
    [rfc-helper.openai :as ai]))

(def a-and-d-guide "practical_analysis_and_design.md")

(def templates
  {:a-and-d-doc-v1 "analysis_and_design_doc_v1.md"
   :rfc->symptoms "prompt_rfc_to_symptoms.md"
   :rfc->problem "prompt_rfc_to_problem.md"
   :problem->better-problem "prompt_problem_to_better_problem.md"
   :rfc->criteria "prompt_rfc_to_criteria.md"
   :rfc->solutions "prompt_rfc_to_solutions.md"})

(defn merge-template
  [template vars]
  (apply format (slurp (get templates template)) vars))

(defn rfc->symptoms
  [a-and-d rfc]
  (:completion-content (ai/complete-chat (merge-template :rfc->symptoms [a-and-d rfc]))))

(defn rfc->problem
  [a-and-d rfc]
  (-> (:completion-content (ai/complete-chat (merge-template :rfc->problem [a-and-d rfc])))
      (string/replace"```json" "")
      (string/replace "```" "")
      json/parse-string))

(defn problem->better-problem
  [symptoms problem a-and-d]
  (:completion-content (ai/complete-chat (merge-template :problem->better-problem [symptoms problem a-and-d]))))

(defn rfc->criteria
  [a-and-d rfc]
  (:completion-content (ai/complete-chat (merge-template :rfc->criteria [a-and-d rfc]))))

(defn rfc->solutions
  [a-and-d rfc]
  (-> (:completion-content (ai/complete-chat (merge-template :rfc->solutions [a-and-d rfc])))
      (string/replace"```json" "")
      (string/replace "```" "")
      json/parse-string ))

(defn generate-a-and-d-doc-v1
  "
  TODO docstring this, also note that it could be parallelized (calls to chat complete))
  "
  [rfc-file out-file]
  (let [rfc (slurp rfc-file)
        a-and-d (slurp a-and-d-guide)
        symptoms (rfc->symptoms a-and-d rfc)
        [problem subject original-url] (rfc->problem a-and-d rfc)
        [solutions additional-solutions approach] (rfc->solutions a-and-d rfc) ]
    (spit out-file (merge-template :a-and-d-doc-v1
                                   [subject
                                    original-url
                                    symptoms
                                    (problem->better-problem
                                      symptoms
                                      a-and-d
                                      (rfc->problem a-and-d rfc))
                                    solutions
                                    additional-solutions
                                    (rfc->criteria a-and-d rfc)
                                    approach]))))

(comment
  (generate-a-and-d-doc-v1 "rfc.txt" "output.txt"))
