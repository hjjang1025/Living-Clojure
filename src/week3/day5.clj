(ns day5)

; ======Problems=====

; #77

(fn [coll]
   (set (filter #(> (count %) 1)
                (map set (vals (group-by set coll))))))

(= ((fn [coll]
       (set (filter #(> (count %) 1)
                    (map set (vals (group-by set coll)))))) ["meat" "mat" "team" "mate" "eat"])
   #{#{"meat" "team" "mate"}})

(= ((fn [coll]
       (set (filter #(> (count %) 1)
                    (map set (vals (group-by set coll)))))) ["veer" "lake" "item" "kale" "mite" "ever"])
   #{#{"veer" "ever"} #{"lake" "kale"} #{"mite" "item"}})


