(ns dojo.core
  (:require [clojure.string :as s]))

(defn count-lines [str]
  (-> str
     (s/split #"\n")
     (count)))

