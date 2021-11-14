(ns day1)

; ======Problems=====


; #1
(= true true)

; #2
(= (- 10 (* 2 3)) 4)

; #3
(= "HELLO WORLD" (.toUpperCase "hello world"))

; #4
(= (list :a :b :c) '(:a :b :c))

; #5
(= '(1 2 3 4) (conj '(2 3 4) 1))
(= '(1 2 3 4) (conj '(3 4) 2 1))

; #6
(= [:a :b :c] (list :a :b :c) (vec '(:a :b :c)) (vector :a :b :c))

; #7
(= [1 2 3 4] (conj [1 2 3] 4))
(= [1 2 3 4] (conj [1 2] 3 4))

; #8
(= #{:a :b :c :d} (set '(:a :a :b :c :c :c :c :d :d)))
(= #{:a :b :c :d} (clojure.set/union #{:a :b :c} #{:b :c :d}))

; #9
(= #{1 2 3 4} (conj #{1 4 3} 2))

; #10
(= 20 ((hash-map :a 10, :b 20, :c 30) :b))
(= 20 (:b {:a 10, :b 20, :c 30}))

; #11
(= {:a 1, :b 2, :c 3} (conj {:a 1} {:b 2} [:c 3]))

; #12
(= 3 (first '(3 2 1)))
(= 3 (second [2 3 4]))
(= 3 (last (list 1 2 3)))