(ns day2)

; ======Problems=====
; #46

(fn [f]
  (letfn [(g [a b] (f b a))]
    g))

; ------------------------------
(= 3 (((fn [f]
         (letfn [(g [a b] (f b a))]
           g)) nth) 2 [1 2 3 4 5]))
(= true (((fn [f]
            (letfn [(g [a b] (f b a))]
              g)) >) 7 8))
(= 4 (((fn [f]
         (letfn [(g [a b] (f b a))]
           g)) quot) 2 8))
(= [1 2 3] (((fn [f]
               (letfn [(g [a b] (f b a))]
                 g)) take) [1 2 3 4 5] 3))


; #44

(fn [i coll]
  (letfn [(get-range [i len]
            (if (> i -1)
              (range i (+ i len))
              (get-range (+ i len) len)))]
    (let [infinite-coll (cycle coll)
          range-i (get-range i (count coll))]
      (map (partial nth infinite-coll) range-i))))

; ---------------------------------
(= ((fn [i coll]
      (letfn [(get-range [i len]
                (if (> i -1)
                  (range i (+ i len))
                  (get-range (+ i len) len)))]
        (let [infinite-coll (cycle coll)
              range-i (get-range i (count coll))]
          (map (partial nth infinite-coll) range-i)))) 2 [1 2 3 4 5]) '(3 4 5 1 2))

(= ((fn [i coll]
      (letfn [(get-range [i len]
                (if (> i -1)
                  (range i (+ i len))
                  (get-range (+ i len) len)))]
        (let [infinite-coll (cycle coll)
              range-i (get-range i (count coll))]
          (map (partial nth infinite-coll) range-i)))) -2 [1 2 3 4 5]) '(4 5 1 2 3))

(= ((fn [i coll]
      (letfn [(get-range [i len]
                (if (> i -1)
                  (range i (+ i len))
                  (get-range (+ i len) len)))]
        (let [infinite-coll (cycle coll)
              range-i (get-range i (count coll))]
          (map (partial nth infinite-coll) range-i)))) 6 [1 2 3 4 5]) '(2 3 4 5 1))

(= ((fn [i coll]
      (letfn [(get-range [i len]
                (if (> i -1)
                  (range i (+ i len))
                  (get-range (+ i len) len)))]
        (let [infinite-coll (cycle coll)
              range-i (get-range i (count coll))]
          (map (partial nth infinite-coll) range-i)))) 1 '(:a :b :c)) '(:b :c :a))

(= ((fn [i coll]
      (letfn [(get-range [i len]
                (if (> i -1)
                  (range i (+ i len))
                  (get-range (+ i len) len)))]
        (let [infinite-coll (cycle coll)
              range-i (get-range i (count coll))]
          (map (partial nth infinite-coll) range-i)))) -4 '(:a :b :c)) '(:c :a :b))

