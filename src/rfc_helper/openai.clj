(ns rfc-helper.openai
  (:require 
    [cheshire.core :as json]
    [clj-http.client :as client]))

(def response-body->completion-content (comp :content :message first :choices))
(def response-body->total-tokens (comp :total_tokens :usage))

(defn complete-chat
  [prompt]
  (let [response-body (-> (client/post "https://api.openai.com/v1/chat/completions"
                                       {:headers {:Authorization (str "Bearer " (System/getenv "OPENAI_API_KEY"))
                                                  :Content-Type "application/json"}
                                        :body (json/generate-string {:model "gpt-4-turbo-preview"
                                                                     :messages [{:role "user"
                                                                                 :content prompt}]})})
                          :body
                          (json/parse-string true))]
    {:completion-content (response-body->completion-content response-body)
     :total-tokens (response-body->total-tokens response-body)}))

(comment
  (complete-chat "what is my name?")
  )
