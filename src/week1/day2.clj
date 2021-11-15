(ns day2)

; ======Problems=====


; #13
(= [20 30 40] (rest [10 20 30 40]))

; #14
(= 8 ((fn add-five [x] (+ x 5)) 3))

(= 8 ((fn [x] (+ x 5)) 3))

(= 8 (#(+ % 5) 3))

(= 8 ((partial + 5) 3))

; #15
(= (* 2 2) 4)

(= (* 2 3) 6)

(= (* 2 11) 22)

(= (* 2 7) 14)

; #16
(= ((fn [name] (str "Hello, " name "!")) "Dave") "Hello, Dave!")

(= ((fn [name] (str "Hello, " name "!")) "Jenn") "Hello, Jenn!")

(= ((fn [name] (str "Hello, " name "!")) "Rhea") "Hello, Rhea!")

; #17
(= '(6 7 8) (map #(+ % 5) '(1 2 3)))

; #18
(= '(6 7) (filter #(> % 5) '(3 4 5 6 7)))

; #35
(= 7 (let [x 5] (+ 2 x)))

(= 7 (let [x 3, y 10] (- y x)))

(= 7 (let [x 21] (let [y 3] (/ x y))))

; #36
(= 10 (let [x 7 y 3 z 1] (+ x y)))

(= 4 (let [x 7 y 3 z 1] (+ y z)))

(= 1 (let [x 7 y 3 z 1] z))