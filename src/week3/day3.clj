(ns day3)

; ======Problems=====


; #43
(fn [nums x]
  (let [array (range x)]
    (map (fn [i]
           (keep-indexed #(when (= (mod (inc %1) x)
                                   (mod (inc i) x)) %2) nums)) array)))

; ------------------------------
(= ((fn [nums x]
      (let [array (range x)]
        (map (fn [i]
               (keep-indexed #(when (= (mod (inc %1) x)
                                       (mod (inc i) x)) %2) nums)) array))) [1 2 3 4 5 6] 2) '((1 3 5) (2 4 6)))

(= ((fn [nums x]
      (let [array (range x)]
        (map (fn [i]
               (keep-indexed #(when (= (mod (inc %1) x)
                                       (mod (inc i) x)) %2) nums)) array))) (range 9) 3) '((0 3 6) (1 4 7) (2 5 8)))

(= ((fn [nums x]
      (let [array (range x)]
        (map (fn [i]
               (keep-indexed #(when (= (mod (inc %1) x)
                                       (mod (inc i) x)) %2) nums)) array))) (range 10) 5) '((0 5) (1 6) (2 7) (3 8) (4 9)))



; #50
(fn [coll]
  (let [type-list (set (map type coll))]
    (map (fn [t]
           (keep #(if (= t (type %)) %) coll)) type-list)))

; -----------------------------------------
(= (set ((fn [coll]
           (let [type-list (set (map type coll))]
             (map (fn [t]
                    (keep #(if (= t (type %)) %) coll)) type-list))) [1 :a 2 :b 3 :c])) #{[1 2 3] [:a :b :c]})

(= (set ((fn [coll]
           (let [type-list (set (map type coll))]
             (map (fn [t]
                    (keep #(if (= t (type %)) %) coll)) type-list))) [:a "foo"  "bar" :b])) #{[:a :b] ["foo" "bar"]})

(= (set ((fn [coll]
           (let [type-list (set (map type coll))]
             (map (fn [t]
                    (keep #(if (= t (type %)) %) coll)) type-list))) [[1 2] :a [3 4] 5 6 :b])) #{[[1 2] [3 4]] [:a :b] [5 6]})

