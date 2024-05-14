# Practical Analysis and Design (A&D)

Right now, this is just a collection of notes, but need a way to refer to it from prompts.

Most of the content here should be attributed directly to Rich & Stu.

<!-- vim-markdown-toc Marked -->

* [Design](#design)
* [Ideas vs Details](#ideas-vs-details)
* [Questions](#questions)
* [Critical Thinking](#critical-thinking)
* [Problems](#problems)
    * [Leveraging Problems](#leveraging-problems)
    * [How To Describe Problems](#how-to-describe-problems)
        * [Bias](#bias)
        * [Ambiguity](#ambiguity)
    * [How To Refine Problem Statements](#how-to-refine-problem-statements)
        * [Symptoms vs Root Cause](#symptoms-vs-root-cause)
        * [Solution Encoding](#solution-encoding)
        * [Ambiguity](#ambiguity)
        * [Objective / Obstacle Format](#objective-/-obstacle-format)
* [Use Cases](#use-cases)
* [Decision Matrices](#decision-matrices)
    * [Solutions (columns)](#solutions-(columns))
    * [Criteria (rows)](#criteria-(rows))
        * [Anti-patterns](#anti-patterns)
            * [Boolean](#boolean)
            * [Characteristics](#characteristics)
            * [Verbosity](#verbosity)
        * [Refinements](#refinements)
            * [Intention](#intention)
            * [Add Succinctness](#add-succinctness)
            * [Simplify](#simplify)
        * [Starting Criteria](#starting-criteria)
* [Why Do This?](#why-do-this?)
* [What Does Progress Feel Like?](#what-does-progress-feel-like?)
* [What if I get stuck?](#what-if-i-get-stuck?)
* [Why Does This Feel Hard?](#why-does-this-feel-hard?)
* [How do I improve?](#how-do-i-improve?)
* [Tools](#tools)

<!-- vim-markdown-toc -->

## Design

* Good design is about taking things away, not adding them -Rich

## Ideas vs Details
* Stay in the idea space as long as possible. Strenuously avoid details. Answers oftentimes are found here, by pushing
  exhaustively on this.
* Staying in the idea space is the aspect of this process people struggle with the most. It takes discipline & practice
  to accomplish.
* Seek out & pair with folks with patience, experience and a willingness to keep you in the idea space.
* Don’t co-identify with your ideas. You’re a source of ideas, some good, some bad. You are not your ideas.

## Questions
* Questioning is a way to build a deeper understanding, to understand the nature of a thing.
* Questioning is an integral part of critical thinking.
* Being questioned can feel like being poked. Be aware of that, get good at asking questions. Get good at being asked
  questions.
* Questioning, especially Socratically, works best when trust / rapport has already been established. The higher the
  level of trust, the more you’re able to think critically (together).
* Be transparent that you’re trying to help someone see their own bias, so that they can be critical of it.
* Many times, what you’re questioning is a person’s intuition. They value it (so should you), but they might not easily
  be able to explain it. This can be frustrating, especially depending on your approach. Don’t place the burden of
  explaining it on them. Assume their intuition is valid and patiently work with them to articulate the reason & logic
  which support their idea.

## Critical Thinking
* Critical thinking exposes flaws.
* Critical thinking is about judging (effectively) by eliminating bias using reasoning & rational thinking.
* Sometimes when you judge things, you give it a thumbs down.
* ”Recognizing weakness strength” - Rich
* ”Not everything is awesome. Negativity can be a [huge] driver for creativity.” - Rich
  * Example: pointing out something you don’t like about the current solution lets you ask: can we do this except
    without this one aspect?
* Don’t be afraid to face criticism. Practice on your own ideas. Be most critical of your own ideas.

## Problems
Discovering & diagnosing insightful problems is neither easy, nor simple.

### Leveraging Problems
* Stay connected to problems. Restate the problem frequently, keep it in your face throughout the process. Continually
  re-anchor yourself to the problem.
* Value finding the best ideas over being right.
* Value solving problems over building things.
* You can dig “downward”, towards technology, by asking “why?”
* You can dig “upward”, towards users / the world, by asking “why is this a problem?”
* Whatever “level” of problem you end up with, that’s the spot you’ll be able to get leverage, by comparing categorical
  solutions. The higher (closer to the user) level problem you consider, the more leverage, but probably the broader /
  lengthier the discussion / exploration.
* It’s easier to dig into the tech, and solve problems there, but you’ve got less leverage.

### How To Describe Problems
statements are sometimes difficult to discover, but lead to far more impactful solutions. The process of discovering, or
identifying (the nature of) a problem by the examination of its symptoms, is known as diagnosis. Diagnosis is subject to
the same constraints as any other process: the quality of the outputs – the problem statement – is directly proportional
to the quality of the inputs – the description of the problem’s symptoms.

Symptoms, in software systems, can take a variety of forms such as:

* feature requests
* user pain or friction
* bug or incident reports
* undesirable system properties such as high cost, poor efficiency, scalability, fault tolerance, etc

#### Bias
When describing symptoms, it is extremely important to avoid bias. State facts plainly. Avoid curating or grouping lists
of symptoms (at least initially). Try to state facts, as concisely as possible (1-2 sentences per symptom). Avoid
lengthy narrative, or story telling, as this is one of the primary ways to introduce bias early in the process of
problem diagnosis.

When collecting reports from users, where subjectivity or bias is evident, rather than omit it, simply attribute it to
the user clearly. For example “the app is too slow” becomes “on August 4th, we receive 231 complaints about delays when
processing credit card payments”.

#### Ambiguity
Avoid ambiguous terms, like “some” or “too slow”. Instead, prefer precision like “53%”, or “p99 latency > 100 msec”.
When (date, time of day, etc) is often very useful when diagnosing later.

### How To Refine Problem Statements
solutions to problems, like any process, the quality of the output (the solution) is directly proportional to the
quality of the inputs (problems considered). Insightful problem statements lead to powerful solutions.

The following describes some anti-patterns to problem statements, reasons & suggestions on how to avoid them.

#### Symptoms vs Root Cause
Frequently, initial attempts to describe problems usually involve descriptions of symptoms. Examples of symptoms might
include:

* feature requests
* user pain or friction
* bug or incident reports
* undesirable system properties such as high cost, poor efficiency, scalability, fault tolerance, etc

For example, the statement “I have a headache” describes a symptom. While it is painful (and problematic), a headache is
usually the result of other conditions such as dehydration, lack of sleep, etc.

Reusable solutions to categorical problems are almost always preferable to collections of bespoke solutions, resulting
in simpler systems (which are cheaper & more flexible).

#### Solution Encoding

Frequently, initial attempts at problem statements also contain (or encode) solutions. For example: 

“The foo service’s p99 latency violates its SLA, due to inefficient database querying”. 

In this example, the problem is that the service is violating its SLA. However, by attributing that behavior to
inefficient database querying, the solution space has been implicitly restricted to query optimization. The fact that
database queries are not optimized is useful information, but there are other, categorical solutions to such problems
such as scale, caching, etc. It is entirely possible that the intuition regarding query efficiency is sound, and that
optimization is called for. But there are also a myriad of reasons why it might not be the best solution to the problem.

By avoiding encoding solutions within the problem statement, you further prevent bias, as well as artificially
restricting the solution space. This will allow you to consider (the tradeoffs of) categorical solutions to your
problem.

#### Ambiguity

Try to make problem statements as precise as possible. Avoid terms that convey emotion, or lack precision. For example
“Users don’t like how slow the app is” could be improved to describe exactly what interactions within the app are
causing user dissatisfaction and why. Be as specific as possible, while retaining succinctness. 

#### Objective / Obstacle Format

Transforming problem statements into a collection of Objective / Obstacle pairs is one way to avoid focusing on
symptoms, or solutions. For example, the problem statement “The app is displaying payment information slowly because of
high latency in the Foo service”, can be restated in Objective / Obstacle format as:

* Objective: Display payment information within 100 msec (p99)
* Obstacle: p99 latency of the Foo service > 500 msec

## Use Cases
* Use case is similar to a symptom report, but informed by an understanding of the problem. Example:
  * Symptom: I have a headache
  * Use case: The user is trying to read w/ the wrong glasses
* Use cases are “instances” of a problem.
* Having multiple use cases / problem instances to work from helps you build a good general tool (vs just saying I want
  to make something that's extensible). 

## Decision Matrices
Decision Matrices are a structured thinking technique used to evaluate tradeoffs between solutions (to a problem) across
a set of criteria, used to select an approach (to solving the problem).

### Solutions (columns)
Decision Matrices are used to contrast solutions, by examining their tradeoffs.

### Criteria (rows)
Criteria are used to select (judge) the best of the considered solutions to a problem, primarily by helping to highlight
the tradeoffs – the strengths & _especially_ the weaknesses – of each solution.Typically, an initial description of the
problem will lead to an understanding of some of the important criteria. As a Decision Matrix is fleshed out, criteria
will be added, removed, and changed, reflecting expansion of one’s understanding of the nature of the problem &
tradeoffs in the solution space. 

#### Anti-patterns

##### Boolean
Phrasing criteria in a way to suggest a boolean / binary answer are sometimes effective ways to begin, but usually
indicate you care about something more general. For example, the criteria “delivery by end of Q1”, can be generalized to
“time to market”. It may be the case that a solution is actually deliverable very shortly after Q1, and is still worth
considering.

##### Characteristics
Criteria are about judging things, comparing them to one another in a way that helps determine the best option. It isn’t
useful to list characteristics of solutions that don’t help accomplish that, and rather, creates noise in a Decision
Matrix. For example “Open sourceable” might be interesting, but in many situations won’t be a useful way to
differentiate between solutions.

##### Verbosity
Using paragraphs, even sentences to express a single criteria hurt the comprehension of a Decision Matrix.

#### Refinements

##### Intention
It’s useful to continually ask yourself why you care about a certain criteria. For example, is “time to market” really
what you care about, or is it the underlying regulatory implications of delay? This is especially useful over the life
of a Decision Matrix. Many times, you’ll start with fairly broad criteria, but increase their specificity over time.

##### Add Succinctness
Use single words, or short phrases to express each criteria. Strive for succinct, precise criteria. This is often quite
difficult, but the exercise of attempting to condense sentences or paragraphs of text to a single word or phrase is a
useful way to expand your understanding of the nature of the problem & solution space.

One way to accomplish this is to express the criteria as an “-ility”. For example “cost” could be rephrased as
“affordability”.

##### Simplify
Criteria should indicate a single concept. Break a single complex criteria into multiple simpler criteria, if they can
be decoupled. Look for redundancy or overlap between criteria and eliminate it. For example, “data size” could possibly
be split into “data cardinality” and “storage size” (if those are actually what you care about).

#### Starting Criteria
People often experience difficulty listing the initial set of criteria, when starting a new Decision Matrix. Below are a
few examples that are usually worth at least considering:

- Affordability
- Efficiency
- Scalability
- Implementation difficulty / complexity
- Time to market
- Market & competitive conditions
- Entropy added to existing systems
- Problems introduced by the solution
- Operational requirements (burden)
- Alignment with organizational goals / strategy
- User experience

## Why Do This?
* Solving problems categorically delivers value multiple times over. Solving the same problem repeatedly is expensive.
* Solving problems is cheaper the further to the left you are in analysis < design < impl < test < deploy.
* Confidence. How can you be confident when you’ve got to dive into some problem space you know little or nothing about,
  and come up with a solution? When you’ve rigorously probed at and understand the nature of a categorical problem, and
  you’ve explored the solution space, you've done an expansive/divergent analysis and really understand the existing
  solutions to this problem, if they exist, and their tradeoffs, you’ll end up with clear, logical reasons for deciding
  to build (or not build) a thing.

## What Does Progress Feel Like?
* You should notice a cadence of expansion, followed by contraction which is repeated throughout the process.
* You should be able to perceive your understanding of a problem, its solutions increasing, day by day.
* You change your mind about something.
* Things that were complex or intimidating become clear or obvious.
* You’re looking at & talking about a list of fundamentals. This is a good place to be.
* You find a better word to describe something.
* You discover important criteria that you didn’t originally see.
* You discover a categorically different solution.

## What if I get stuck?
* Many times, especially when thinking at a categorical level, looking for a second or third solution option, or trying
  to disentangle the important parts of a single solution (looking for categories), getting up, away from the computer,
walking, talking to myself, etc has been the only path forward. Many times, you can’t force it. Walk away, do something
else, go to sleep.

## Why Does This Feel Hard?
* You’ve got a deep bias towards action.
* You’ve been conditioned (by the software engineering profession & culture) to value making things, writing code, etc.
* We’ve grown up in a culture of just trying stuff out, not having to think. This practice encourages you to think, to
  rediscover old things, be intentional -Christian
* Being poked is unfamiliar to you.
* The first 1000 golf balls you hit don’t make you feel good. But once you hit one in the air, it feels great & keeps
  you coming back for more!
* Keep going, discomfort is a signal of growth. Embrace it.

## How do I improve?
* Sometimes the dynamics associated w/ doing this as a team are hard and take time to do well. Doing it on your own is a
  good way to practice.

## Tools
* Tools should help you stay connected to the problem / objective. A tool that takes you away from the idea space will
  fool you into thinking you need more details than you do. (Dan re: Rich) What do I find myself wanting to do when
  someone sends me an RFC
