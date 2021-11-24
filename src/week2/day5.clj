(ns day5)

; ======Problems=====


; #97
; Pascal Triangle
; 더 예쁘게 정리하고싶은데..

(fn [n] (last (take n ((fn p-tri*
                         ([] (p-tri* [] 0))
                         ([coll n]
                          (let [new-coll ((fn [c]
                                            (if (= 0 (count c))
                                              [1]
                                              (concat [1] (map + c (rest c)) [1])))
                                          coll)]
                            (cons new-coll (lazy-seq (p-tri* new-coll (inc n)))))))))))

--------------------------------------------

(= ((fn [n] (last (take n ((fn p-tri*
                             ([] (p-tri* [] 0))
                             ([coll n]
                              (let [new-coll ((fn [c]
                                                (if (= 0 (count c))
                                                  [1]
                                                  (concat [1] (map + c (rest c)) [1])))
                                              coll)]
                                (cons new-coll (lazy-seq (p-tri* new-coll (inc n))))))))))) 1) [1])

(= (map (fn [n] (last (take n ((fn p-tri*
                                 ([] (p-tri* [] 0))
                                 ([coll n]
                                  (let [new-coll ((fn [c]
                                                    (if (= 0 (count c))
                                                      [1]
                                                      (concat [1] (map + c (rest c)) [1])))
                                                  coll)]
                                    (cons new-coll (lazy-seq (p-tri* new-coll (inc n))))))))))) (range 1 6))
   [     [1]
    [1 1]
    [1 2 1]
    [1 3 3 1]
    [1 4 6 4 1]])

(= ((fn [n] (last (take n ((fn p-tri*
                             ([] (p-tri* [] 0))
                             ([coll n]
                              (let [new-coll ((fn [c]
                                                (if (= 0 (count c))
                                                  [1]
                                                  (concat [1] (map + c (rest c)) [1])))
                                              coll)]
                                (cons new-coll (lazy-seq (p-tri* new-coll (inc n))))))))))) 11)
   [1 10 45 120 210 252 210 120 45 10 1])


(= ((fn [n] (last (take n ((fn p-tri*
                             ([] (p-tri* [] 0))
                             ([coll n]
                              (let [new-coll ((fn [c]
                                                (if (= 0 (count c))
                                                  [1]
                                                  (concat [1] (map + c (rest c)) [1])))
                                              coll)]
                                (cons new-coll (lazy-seq (p-tri* new-coll (inc n))))))))))) 11)
   [1 10 45 120 210 252 210 120 45 10 1])


; brave clojure 5장에서 도움이 된 함수
(defn tri*
  ([] (tri* 0 1))
  ([sum n]
   (let [new-sum (+ sum n)]
     (cons new-sum (lazy-seq (tri* new-sum (inc n)))))))

(def tri (tri*))

(take 5 tri)

; -----------------------------------------


; [1 1] -> [2]
; [1 2 1] -> [3 3]
(map + [1 2 1] (rest [1 2 1])) ;으로 해결

; -------------------------------------------

(defn p-tri*
  ([] (p-tri* [] 0))
  ([coll n]
   (let [new-coll ((fn [c]
                     (if (= 0 (count c))
                       [1]
                       (concat [1] (map + c (rest c)) [1])))
                   coll)]
     (cons new-coll (lazy-seq (p-tri* new-coll (inc n)))))))

(def p-tri (p-tri*))

(take 5 p-tri)

; ------------------------------------------
(defn p-tri-2 [n]
  (take n p-tri))

(p-tri-2 2)


;정답!
((fn [n] (last (take n ((fn p-tri*
                          ([] (p-tri* [] 0))
                          ([coll n]
                           (let [new-coll ((fn [c]
                                             (if (= 0 (count c))
                                               [1]
                                               (concat [1] (map + c (rest c)) [1])))
                                           coll)]
                             (cons new-coll (lazy-seq (p-tri* new-coll (inc n))))))))))) 3)

