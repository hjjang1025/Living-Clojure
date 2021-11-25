(ns day1)

; ======Problems=====

; #95

; 정답1 정답 인정은 되었는데 Repl에서 오류
(fn b-tree? [edge]
   (cond
      (nil? edge) true
      (not= 3 (count edge)) false
      :else (every? true? (map b-tree? (rest edge)))))

; ----------------------------

(= ((fn b-tree? [edge]
       (cond
          (nil? edge) true
          (not= 3 (count edge)) false
          :else (every? true? (map b-tree? (rest edge))))) '(:a (:b nil nil) nil))
   true)

(= ((fn b-tree? [edge]
       (cond
          (nil? edge) true
          (not= 3 (count edge)) false
          :else (every? true? (map b-tree? (rest edge))))) '(:a (:b nil nil)))
   false)

(= ((fn b-tree? [edge]
       (cond
          (nil? edge) true
          (not= 3 (count edge)) false
          :else (every? true? (map b-tree? (rest edge))))) [1 nil [2 [3 nil nil] [4 nil nil]]])
   true)

(= ((fn b-tree? [edge]
       (cond
          (nil? edge) true
          (not= 3 (count edge)) false
          :else (every? true? (map b-tree? (rest edge))))) [1 [2 nil nil] [3 nil nil] [4 nil nil]])
   false)

(= ((fn b-tree? [edge]
       (cond
          (nil? edge) true
          (not= 3 (count edge)) false
          :else (every? true? (map b-tree? (rest edge))))) [1 [2 [3 [4 nil nil] nil] nil] nil])
   true)

(= ((fn b-tree? [edge]
       (cond
          (nil? edge) true
          (not (seq? edge)) false
          (not= 3 (count edge)) false
          :else (every? true? (map b-tree? (rest edge))))) [1 [2 [3 [4 false nil] nil] nil] nil])
   false)

(= ((fn b-tree? [edge]
       (cond
          (nil? edge) true
          (not= 3 (count (vector edge))) false
          :else (every? true? (map b-tree? (rest edge))))) '(:a nil ()))
   false)


; #96
(= ((fn symmetric? [[_ left right]]
       (= left
          ((fn mirror [[n left right]]
              (if (nil? n)
                 nil
                 [n (mirror right) (mirror left)]))
           right))) '(:a (:b nil nil) (:b nil nil))) true)

; ---------------------------------

(= ((fn symmetric? [[_ left right]]
       (= left
          ((fn mirror [[n left right]]
              (if (nil? n)
                 nil
                 [n (mirror right) (mirror left)]))
           right))) '(:a (:b nil nil) nil)) false)

(= ((fn symmetric? [[_ left right]]
       (= left
          ((fn mirror [[n left right]]
              (if (nil? n)
                 nil
                 [n (mirror right) (mirror left)]))
           right))) '(:a (:b nil nil) (:c nil nil))) false)

(= ((fn symmetric? [[_ left right]]
       (= left
          ((fn mirror [[n left right]]
              (if (nil? n)
                 nil
                 [n (mirror right) (mirror left)]))
           right))) [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
                     [2 [3 nil [4 [6 nil nil] [5 nil nil]]] nil]])
   true)

(= ((fn symmetric? [[_ left right]]
       (= left
          ((fn mirror [[n left right]]
              (if (nil? n)
                 nil
                 [n (mirror right) (mirror left)]))
           right))) [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
                       [2 [3 nil [4 [5 nil nil] [6 nil nil]]] nil]])
   false)

(= ((fn symmetric? [[_ left right]]
       (= left
          ((fn mirror [[n left right]]
              (if (nil? n)
                 nil
                 [n (mirror right) (mirror left)]))
           right))) [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
                     [2 [3 nil [4 [6 nil nil] nil]] nil]])
   false)


