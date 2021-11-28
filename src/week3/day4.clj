(ns day4)

; ======Problems=====


; #88
; Prime numbers

(fn prime-list [n]
  (letfn [(prime? [x] (empty? (filter #(= 0 (mod x  %)) (range 2 x))))]
    (take n (filter #(prime? %) (iterate inc 2)))))


;----------------------------------
(= ((fn prime-list [n]
      (letfn [(prime? [x] (empty? (filter #(= 0 (mod x  %)) (range 2 x))))]
        (take n (filter #(prime? %) (iterate inc 2))))) 2) [2 3])

(= ((fn prime-list [n]
      (letfn [(prime? [x] (empty? (filter #(= 0 (mod x  %)) (range 2 x))))]
        (take n (filter #(prime? %) (iterate inc 2))))) 5) [2 3 5 7 11])

(= (last ((fn prime-list [n]
            (letfn [(prime? [x] (empty? (filter #(= 0 (mod x  %)) (range 2 x))))]
              (take n (filter #(prime? %) (iterate inc 2))))) 100)) 541)



