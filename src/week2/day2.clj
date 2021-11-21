(ns day2)

; ======Problems=====


; #51
(= [1 2 [3 4 5] [1 2 3 4 5]] (let [[a b & c :as d] [1 2 3 4 5]] [a b c d]))

; #83
; return true if some of the parameters are true, but not all of the parameters are true.
; Otherwise your function should return false.
(= false ((fn [& data] (> (count (set data)) 1)) false false))
(= true ((fn [& data] (> (count (set data)) 1)) true false))
(= false ((fn [& data] (> (count (set data)) 1)) true))
(= true ((fn [& data] (> (count (set data)) 1)) false true false))
(= false ((fn [& data] (> (count (set data)) 1)) true true true))
(= true ((fn [& data] (> (count (set data)) 1)) true true true false))

; #66
; 최대공약수 (greatest common divisor)
(= ((fn [& nums]
      (let [[small big] (sort nums)]
           (if (zero? small)
             big
             (recur [small (mod big small)])))) 2 4) 2)
(= ((fn [& nums]
      (let [[small big] (sort nums)]
           (if (zero? small)
             big
             (recur [small (mod big small)])))) 10 5) 5)
(= ((fn [& nums]
      (let [[small big] (sort nums)]
           (if (zero? small)
             big
             (recur [small (mod big small)])))) 5 7) 1)
(= ((fn [& nums]
      (let [[small big] (sort nums)]
           (if (zero? small)
             big
             (recur [small (mod big small)])))) 1023 858) 33)

; java 함수를 사용하는 방법 -> 오답 처리됨
;(fn [a b] (.gcd (biginteger a) (biginteger b)))


