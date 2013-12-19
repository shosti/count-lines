(ns dojo.core
  (:require [clojure.string :as s]))

(defn count-lines [str]
  (-> str
     (s/split-lines)
     (strip-whitespace)
     (remove-blank-lines)
     (remove-block-comments)
     (remove-line-comments)
     (count)))

(defn strip-whitespace [lines]
  (map s/trim lines))

(defn remove-blank-lines [lines]
  (filter (complement s/blank?) lines))

(defn remove-block-comments [lines]
  (reduce (fn [[lines in-comment] line])))

(defn remove-line-comments [lines]
  (filter (complement #(re-find #"^//" %))))

(defn get-non-comment-lines [s]
  [])
