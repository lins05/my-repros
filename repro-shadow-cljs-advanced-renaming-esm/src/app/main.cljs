(ns app.main
  (:require #_["/app/util_esm.js" :as ESM]
            ["/app/util_cjs.js" :as CJS]))

(CJS/callDogBark #js {:bark (fn []
                              (println "Bark from CJS!"))} 1)
#_(ESM/callDogBark #js {:bark (fn []
                              (println "Bark from ESM!"))} 1)
