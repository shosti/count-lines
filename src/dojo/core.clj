(ns dojo.core
  (:require [clojure.string :as s]))

(defn strip-whitespace [lines]
  (map s/trim lines))

(defn remove-blank-lines [lines]
  (filter (complement s/blank?) lines))

(defn remove-block-comments [lines]
  #_(reduce (fn [[lines in-comment] line])))

(defn remove-line-comments [lines]
  (filter (complement #(re-find #"^//" %)) lines))

(defn count-lines [str]
  (-> str
     (s/split-lines)
     (strip-whitespace)
     (remove-blank-lines)
     (remove-block-comments)
     (remove-line-comments)
     (count)))


;(count-lines (slurp "sample.txt"))

(defn get-non-comment-lines [lines]
  (->> lines
     (map (fn [line] [true line]))
     (map mark-lines)
     (map (lambda [[comment line] [comment]]))))



