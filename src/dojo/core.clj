(ns dojo.core
  (:require [clojure.string :as s]))

(defn count-lines [s]
  (s/split "hello\there" #"\n"))
