(ns day4)

; ======Problems=====


; #88
; 차집합 구하기

(fn [coll1 coll2]
  (let [union (into (vec coll1) (vec coll2))]
    (->> (frequencies union)
         (filter (fn [[_ v]] (= v 1)))
         (map first)
         (set))))

;----------------------------------

(= ((fn [coll1 coll2]
     (let [union (into (vec coll1) (vec coll2))]
       (->> (frequencies union)
            (filter (fn [[_ v]] (= v 1)))
            (map first)
            (set)))) #{1 2 3 4 5 6} #{1 3 5 7}) #{2 4 6 7})

(= ((fn [coll1 coll2]
      (let [union (into (vec coll1) (vec coll2))]
        (->> (frequencies union)
             (filter (fn [[_ v]] (= v 1)))
             (map first)
             (set)))) #{:a :b :c} #{}) #{:a :b :c})
(= ((fn [coll1 coll2]
      (let [union (into (vec coll1) (vec coll2))]
        (->> (frequencies union)
             (filter (fn [[_ v]] (= v 1)))
             (map first)
             (set)))) #{} #{4 5 6}) #{4 5 6})

(= ((fn [coll1 coll2]
      (let [union (into (vec coll1) (vec coll2))]
        (->> (frequencies union)
             (filter (fn [[_ v]] (= v 1)))
             (map first)
             (set)))) #{[1 2] [2 3]} #{[2 3] [3 4]}) #{[1 2] [3 4]})



; #100
; 최소공배수(lcm) = a * b / gcd(최대공약수)

; REPL에서는 정답인데 사이트에서 오답처리됨
(fn [& nums]
  (let
    [gcd (fn gcd [a b] (if (= 0 b) a (gcd b (mod a b))))
     lcm (fn [a b] (/ (* a b) (gcd a b)))]
    (reduce lcm nums)))

; 다른 정답으로도 분수가 들어간 3,4,5번째 문제에 오답처리가 되는 것으로 보아
; 정답처리에 문제가 있는 듯

-----------------------------

(== ((fn [& nums]
       (let
         [gcd (fn gcd [a b] (if (= 0 b) a (gcd b (mod a b))))
          lcm (fn [a b] (/ (* a b) (gcd a b)))]
         (reduce lcm nums))) 2 3) 6)

(== ((fn [& nums]
       (let
         [gcd (fn gcd [a b] (if (= 0 b) a (gcd b (mod a b))))
          lcm (fn [a b] (/ (* a b) (gcd a b)))]
         (reduce lcm nums))) 5 3 7) 105)

(== ((fn [& nums]
       (let
         [gcd (fn gcd [a b] (if (= 0 b) a (gcd b (mod a b))))
          lcm (fn [a b] (/ (* a b) (gcd a b)))]
         (reduce lcm nums))) 1/3 2/5) 2)

(== ((fn [& nums]
       (let
         [gcd (fn gcd [a b] (if (= 0 b) a (gcd b (mod a b))))
          lcm (fn [a b] (/ (* a b) (gcd a b)))]
         (reduce lcm nums))) 3/4 1/6) 3/2)

(== ((fn [& nums]
       (let
         [gcd (fn gcd [a b] (if (= 0 b) a (gcd b (mod a b))))
          lcm (fn [a b] (/ (* a b) (gcd a b)))]
         (reduce lcm nums))) 7 5/7 2 3/5) 210)
