(ns day3)

; ======Problems=====


; #107
(fn [times]
  (fn [x]
    (if (= times 0)
      1
      (->> (iterate (partial * x) x)
           (take times)
           (last)))))
; ------------------------------

(= 256
   (((fn [times]
       (fn [x]
         (if (= times 0)
           1
           (->> (iterate (partial * x) x)
                (take times)
                (last))))) 2) 16),
   (((fn [times]
         (fn [x]
           (if (= times 0)
             1
             (->> (iterate (partial * x) x)
                  (take times)
                  (last))))) 8) 2))

(= [1 8 27 64]
   (map ((fn [times]
           (fn [x]
             (if (= times 0)
               1
               (->> (iterate (partial * x) x)
                    (take times)
                    (last))))) 3) [1 2 3 4]))

(= [1 2 4 8 16]
   (map #(((fn [times]
             (fn [x]
               (if (= times 0)
                 1
                 (->> (iterate (partial * x) x)
                      (take times)
                      (last))))) %) 2) [0 1 2 3 4]))

;  #90

(fn [coll-a coll-b]
  (-> (for [a coll-a
            b coll-b]
        [a b])
      (set)))

; -----------------------------------------

(= ((fn [coll-a coll-b]
      (-> (for [a coll-a
                b coll-b]
            [a b])
          (set))) #{"ace" "king" "queen"} #{"♠" "♥" "♦" "♣"})
   #{["ace"   "♠"] ["ace"   "♥"] ["ace"   "♦"] ["ace"   "♣"]
     ["king"  "♠"] ["king"  "♥"] ["king"  "♦"] ["king"  "♣"]
     ["queen" "♠"] ["queen" "♥"] ["queen" "♦"] ["queen" "♣"]})

(= ((fn [coll-a coll-b]
      (-> (for [a coll-a
                b coll-b]
            [a b])
          (set))) #{1 2 3} #{4 5})
   #{[1 4] [2 4] [3 4] [1 5] [2 5] [3 5]})

(= 300 (count ((fn [coll-a coll-b]
                 (-> (for [a coll-a
                           b coll-b]
                       [a b])
                     (set))) (into #{} (range 10))
                  (into #{} (range 30)))))

