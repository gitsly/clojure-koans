(ns koans.12-sequence-comprehensions
  (:require [koan-engine.core :refer :all]))

;; List comprehension. Takes a vector of one or more
;;  binding-form/collection-expr pairs, each followed by zero or more
;;  modifiers, and yields a lazy sequence of evaluations of expr.
;;  Collections are iterated in a nested fashion, rightmost fastest,
;;  and nested coll-exprs can refer to bindings created in prior
;;  binding-forms.  Supported modifiers are: :let [binding-form expr ...],
;;  :while test, :when test.
;;  (take 100 (for [x (range 100000000) y (range 1000000) :while (< y x)] [x y]))


;; (println (for [row [0 1 2]
;;            column [:a :b :c]]
;;        [row column]))

(meditations
  "Sequence comprehensions can bind each element in turn to a symbol"
  (= '(0 1 2 3 4 5)
     (for [x (range 6)]
      x))

  "They can easily emulate mapping"
  (= '(0 1 4 9 16 25)
     (map (fn [x] (* x x))
          (range 6))
     (for [x (range 6)]
      (* x x)))

  "And also filtering"
  (= '(1 3 5 7 9)
     (filter odd? (range 10))
     (for [x (range 10) :when (odd? x)]
       x))

  "Combinations of these transformations is trivial"
  (= '(1 9 25 49 81)
     (map (fn [x] (* x x))
          (filter odd? (range 10)))
     (for [x (range 10) :when (odd? x)]
       (* x x)))

  "More complex transformations simply take multiple binding forms"
  (= [[:top :left] [:top :middle] [:top :right]
      [:middle :left] [:middle :middle] [:middle :right]
      [:bottom :left] [:bottom :middle] [:bottom :right]]

     (for [row [:top :middle :bottom]
           column [:left :middle :right]]
       [row column])))
