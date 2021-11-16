(ns day3)

; ======Problems=====


; #37
(= "ABC" (apply str (re-seq #"[A-Z]+" "bA1B3Ce ")))

; #57
(= '(5 4 3 2 1) ((fn foo [x]
                   (when (> x 0)
                     (conj (foo (dec x)) x))) 5))

; #68
(= [7 6 5 4 3]
   (loop [x 5
          result []]
     (if (> x 0)
       (recur (dec x) (conj result (+ 2 x)))
       result)))

; #71
(= (last (sort (rest (reverse [2 5 4 1 3 6]))))
   (-> [2 5 4 1 3 6] reverse rest sort last)
   5)

; #72
(= (reduce + (map inc (take 3 (drop 2 [2 5 4 1 3 6]))))
   (->> [2 5 4 1 3 6] (drop 2) (take 3) (map inc) (reduce +))
   11)

; #145
(= '(1 5 9 13 17 21 25 29 33 37)
   (for [x (range 40)
         :when (= 1 (rem x 4))]
     x))
; rem : remainder(나머지 연산)

(= '(1 5 9 13 17 21 25 29 33 37)
   (for [x (iterate #(+ 4 %) 0)
           :let [z (inc x)]
           :while (< z 40)]
       z))

(= '(1 5 9 13 17 21 25 29 33 37)
   (for [[x y] (partition 2 (range 20))]
        (+ x y)))
