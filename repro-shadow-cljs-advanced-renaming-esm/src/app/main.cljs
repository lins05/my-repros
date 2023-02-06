(ns app.main
  (:require ["/app/util_esm.js" :as ESM]))

(ESM/callDogBark #js {:bark (fn []
                              (println "Bark from ESM!"))} 1)
