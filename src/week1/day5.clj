(ns day5)

; ======Problems=====

; #30
(= (apply str (reduce (fn [coll x]
                        (if (= x (last coll))
                          coll
                          (conj coll x))) [] "Leeeeeerrroyyy"))
   "Leroy")
(= (reduce (fn [coll x]
             (if (= x (last coll))
               coll
               (conj coll x))) [] [1 1 2 3 3 2 2 3])
   '(1 2 3 2 3))
(= (reduce (fn [coll x]
             (if (= x (last coll))
               coll
               (conj coll x))) [] [[1 2] [1 2] [3 4] [1 2]])
   '([1 2] [3 4] [1 2]))


; #31
(= (partition-by identity [1 1 2 1 1 1 3 3]) '((1 1) (2) (1 1 1) (3 3)))
(= (partition-by identity [:a :a :b :b :c]) '((:a :a) (:b :b) (:c)))
(= (partition-by identity [[1 2] [1 2] [3 4]]) '(([1 2] [1 2]) ([3 4])))

; #41
(= ((fn [coll i]
      (keep-indexed
        #(when (> (mod (inc %1) i) 0) %2) coll))
    [1 2 3 4 5 6 7 8] 3)
   [1 2 4 5 7 8])
(= ((fn [coll i] (keep-indexed #(when (> (mod (inc %1) i) 0) %2) coll)) [:a :b :c :d :e :f] 2) [:a :c :e])
(= ((fn [coll i] (keep-indexed #(when (> (mod (inc %1) i) 0) %2) coll)) [1 2 3 4 5 6] 4) [1 2 3 5 6])

; #45
(= '(1 4 7 10 13) (take 5 (iterate #(+ 3 %) 1)))

; #33
(= ((fn [coll x]
      (->> coll
           (mapcat #(take x (iterate identity %))))) [1 2 3] 2) '(1 1 2 2 3 3))
(= ((fn [coll x]
      (->> coll
           (mapcat #(take x (iterate identity %))))) [:a :b] 4) '(:a :a :a :a :b :b :b :b))
(= ((fn [coll x]
      (->> coll
           (mapcat #(take x (iterate identity %))))) [4 5 6] 1) '(4 5 6))
(= ((fn [coll x]
      (->> coll
           (mapcat #(take x (iterate identity %))))) [[1 2] [3 4]] 2) '([1 2] [1 2] [3 4] [3 4]))
(= ((fn [coll x]
      (->> coll
           (mapcat #(take x (iterate identity %))))) [44 33] 2) [44 44 33 33])

