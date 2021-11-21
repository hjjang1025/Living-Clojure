(ns day1)

; ======Problems=====

; #26
(= ((fn [x]
      (->> [1 1]
           (iterate (fn [[a b]] [b (+ a b)]))
           (map first)
           (take x))) 3) '(1 1 2))
(= ((fn [x]
      (->> [1 1]
           (iterate (fn [[a b]] [b (+ a b)]))
           (map first)
           (take x))) 6) '(1 1 2 3 5 8))
(= ((fn [x]
      (->> [1 1]
           (iterate (fn [[a b]] [b (+ a b)]))
           (map first)
           (take x))) 8) '(1 1 2 3 5 8 13 21))

; #29
(= ((fn [x]
      (->> x
           (filter (set (map char (range 65 91))))
           (apply str))) "HeLlO, WoRlD!")) "HLOWRD"
(empty? ((fn [x]
           (->> x
                (filter (set (map char (range 65 91))))
                (apply str))) "nothing"))
(= ((fn [x]
      (->> x
           (filter (set (map char (range 65 91))))
           (apply str))) "$#A(*&987Zf") "AZ")

;(map char (range 65 91))
;=> (\A \B \C \D \E \F \G \H \I \J \K \L \M \N \O \P \Q \R \S \T \U \V \W \X \Y \Z)

; 실행은 잘되지만 4clojure에서 오답처리된 함수
(fn [x]
  (->> x
       (filter #(Character/isUpperCase %))
       (apply str)))

; #48
; The some function takes a predicate function and a collection.
; It returns the first logical true value of (predicate x) where x is an item in the collection.
(= 6 (some #{2 7 6} [5 6 7 8]))
(= 6 (some #(when (even? %) %) [5 6 7 8]))

; #42
; Write a function which calculates factorials.
(= ((fn [x] (reduce * (range 1 (inc x)))) 1) 1)
(= ((fn [x] (reduce * (range 1 (inc x)))) 3) 6)
(= ((fn [x] (reduce * (range 1 (inc x)))) 5) 120)
(= ((fn [x] (reduce * (range 1 (inc x)))) 8) 40320)

; #52
(= [2 4] (let [[a b c d e f g] (range)] [c e]))