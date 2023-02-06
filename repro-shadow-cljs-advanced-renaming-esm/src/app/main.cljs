(ns app.main
  (:require ["/app/util_esm.js" :as ESM]
            [app.util-cljs :as utils-cljs]))

(ESM/callDogBark #js {:bark (fn []
                                (println "Bark from ESM!"))} 1)

(utils-cljs/call-dog-bark #js {:bark (fn []
                                       (println "Bark from ESM!"))} 1)


(defn go []
  (js/console.log "Go ESM!"))
