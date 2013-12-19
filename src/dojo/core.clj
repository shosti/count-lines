(ns dojo.core
  (:require [clojure.string :as s]))

(defn count-lines [str]
  (-> str
     (s/split-lines)
     (strip-whitespace)
     (remove-blank-lines)
     (count)))

(defn strip-whitespace [lines]
  (map s/trim lines))

(defn remove-blank-lines [lines]
  (filter #(not (s/blank? %)) lines))
