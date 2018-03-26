;; For good info about functions in clojure check:
;; https://coderwall.com/p/panlza/function-syntax-in-clojure

(ns koans.07-functions
  (:require [koan-engine.core :refer :all]))

(defn multiply-by-ten "multiplies a thing by ten, this is the docstring" [n]
  (* 10 n))

(defn square [n] (* n n))

;; This is another way to create a function. Multiplying a param by 2
(def anotherway (fn [a](* 2 a)))

;; This is a non-public function
(defn- nonpublic [a](* 3 a))


;;  "Lets try that again, cant really understand this yet"
;;  (= (15 30)  (#(* 15 %) 1 2))

(meditations
   "Let's try another my homemade anotherway function"
   (= 6 (anotherway 3))

   "Use the non-public function?"
   (= 6 (nonpublic 2))

  "Calling a function is like giving it a hug with parentheses"
  (= 81 (square 9))

  "Functions are usually defined before they are used"
  (= 20 (multiply-by-ten 2))

  "But they can also be defined inline"
  (= 10 ((fn [n] (* 5 n)) 2))

  "Or using an even shorter syntax, The map function applies the anonymous function to each element in the collection"
  (= 60 (#(* 15 %) 4))

  "Even anonymous functions may take multiple arguments"
  (= (+ 4 5 6) (#(+ %1 %2 %3) 4 5 6))

  "Arguments can also be skipped"
  (= "AACC" (#(str "AA" %2) "bb" "CC"))

  "One function can beget another, hint: the fn here is immediately invoked. So whatever it has in its body becomes the function called with args 4 5"
  (= 9 (((fn [] +)) 4 5))

  "Functions can also take other functions as input"
  (= 20 ((fn [f] (f 4 5))
           *))

  "!!! Higher-order functions take function arguments"
  (= 25 ((fn [a] (a 5)) (fn [n] (* n n))) )

  "But they are often better written using the names of functions, note function square is param to the 'fn' "
  (= 25 ((fn [a] (a 5)) square))

  "Lets try my own"
  (= "aa" ((fn [p] (p "a")) (fn [s] (str s s)) ))

)
