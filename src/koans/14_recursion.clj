(ns koans.14-recursion
  (:require [koan-engine.core :refer :all]))

(defn is-even? [n]
   (if (= n 0)
    true
     (not
      (is-even? (dec n)))))

(defn recursive-reverse [coll]
  __)

(defn factorial [n]
  __)

;; (println
;;   (if (eval false)
;;     "eval true"
;;     "eval false"))

;; (println (map is-even? [1 2 3 4]))


(defn is-even-bigint? [n]
  (loop [n   n
         acc true]
    (if (= n 0)
      true
      (recur (dec n) (not acc)))))


;; (defn apan [x] (* 4 x))
;; (println (map is-even-bigint? [100003N]))

;;(defn monk (for [i (range 3)]
;;  (+ i 10)))

;; (println (for [x '(1 2 3)]
;;         (+ 10 x)))


;; (defn fibo [s]
;;  [0 1 1 2 3 5 8 13])

;;--------------------------------------------------------------------------------
(defn fibo [seriesNo]
    (if (or (= seriesNo 0)(= seriesNo 1))
      seriesNo
      (+ (fibo (- seriesNo 1) ) (fibo (- seriesNo 2)))))

(defn fibonachi [length] (map fibo (range length)))

;; Output fibonachi sequence (8 values)
;; (println (fibonachi 9))
;;--------------------------------------------------------------------------------

;; Note: below is prone to Stack Overflow
(defn my-inv-range [a]
  (if (= a 0)
    [a]
    (cons a (my-inv-range (- a 1)) )))

(defn myrange [a]
  (reverse (my-inv-range a)))

;;(println "myrange: " (myrange 100))


;; lets try a recur
(defn myrecurtest ([n, res]
  (if (= n 0)
    res
    (recur (- n 1) (cons n res)))))



(println "myrecurtest: " (myrecurtest 3 []))

(meditations
  "Recursion ends with a base case"
  (= true (is-even? 0))

  "And starts by moving toward that base case"
  (= false (is-even? 1))

  "Having too many stack frames requires explicit tail calls with recur"
  (= false (is-even-bigint? 100003N))

  "Reversing directions is easy when you have not gone far"
  (= '(1) (recursive-reverse [1]))

  "Yet it becomes more difficult the more steps you take"
  (= '(6 5 4 3 2) (recursive-reverse [2 3 4 5 6]))

  "Simple things may appear simple."
  (= 1 (factorial 1))

  "They may require other simple steps."
  (= 2 (factorial 2))

  "Sometimes a slightly bigger step is necessary"
  (= 6 (factorial 3))

  "And eventually you must think harder"
  (= 24 (factorial 4))

  "You can even deal with very large numbers"
  (< 1000000000000000000000000N (factorial 1000N))

  "But what happens when the machine limits you?"
  (< 1000000000000000000000000N (factorial 100003N)))
