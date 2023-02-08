(ns app.util-cljs)

(defn call-dog-bark [^js dog n]
  (doseq [_ (range n)]
    (.bark dog)))
