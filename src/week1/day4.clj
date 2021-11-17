(ns day4)

; ======Problems=====

; #20
(= ((fn [x] (last (drop-last x))) (list 1 2 3 4 5)) 4)
(= ((fn [x] (last (drop-last x))) ["a" "b" "c"]) "b")
(= ((fn [x] (last (drop-last x))) [[1 2] [3 4]]) [1 2])

; #24
(= (reduce + [1 2 3]) 6)
(= (reduce + (list 0 -2 5 5)) 8)
(= (reduce + #{4 2 1}) 7)
(= (reduce + '(0 0 -1)) -1)
(= (reduce + '(1 10 3)) 14)

; #25
(= (filter odd? #{1 2 3 4 5}) '(1 3 5))
(= (filter odd? [4 2 1 6]) '(1))
(= (filter odd? [2 2 4 6]) '())
(= (filter odd? [1 1 1 3]) '(1 1 1 3))

; #27
; Write a function which returns true if the given sequence is a palindrome.
; Hint: "racecar" does not equal '(\r \a \c \e \c \a \r)
(false? ((fn [x] (= (reverse x) (seq x))) '(1 2 3 4 5)))
(true? ((fn [x] (= (reverse x) (seq x))) "racecar"))
(true? ((fn [x] (= (reverse x) (seq x))) [:foo :bar :foo]))
(true? ((fn [x] (= (reverse x) (seq x))) '(1 1 3 3 1 1)))
(false? ((fn [x] (= (reverse x) (seq x))) '(:a :b :c)))

; #32
; Write a function which duplicates each element of a sequence.
(= (mapcat (fn [x] (list x x)) [1 2 3]) '(1 1 2 2 3 3))
(= (mapcat (fn [x] (list x x)) [:a :a :b :b]) '(:a :a :a :a :b :b :b :b))
(= (mapcat (fn [x] (list x x)) [[1 2] [3 4]]) '([1 2] [1 2] [3 4] [3 4]))
(= (mapcat (fn [x] (list x x)) [44 33]) [44 44 33 33])

; true는 잘 나오는데 4clojure 사이트에서 오류
; map (fn [x] (flatten (list x x)))
; flatten 을 쓰지 않기 위해 mapcat 으로 수정해서 해결