(ns test-dojo
  (:refer-clojure :exclude [test])
  (:use midje.sweet
        dojo.core))

(def source-1
  ["-" "// This file contains 3 lines of code"
   "1" "public interface Dave {"
   "-" "  /**"
   "-" "   * count the number of lines in a file"
   "-" "   */"
   "2" "  int countLines(File inFile); // not the real signature!"
   "3" "}"])

(def source-2
  ["-" " /*****"
   "-" " * This is a test program with 5 lines of code"
   "-" " *  \\/* no nesting allowed!"
   "-" " //*****//***/// Slightly pathological comment ending..."
   "-" ""
   "1" "public class Hello {"
   "2" "    public static final void main(String [] args) { // gotta love Java"
   "-" "        // Say hello"
   "3" "      System./*wait*/out./*for*/println/*it*/(\"Hello/*\");"
   "4" "    }"
   "-" ""
   "5" "}"])

(defn get-code-lines [source]
  (->> source
       (partition 2 ,,,)
       (map second ,,,)))

(defn get-code [source]
  (clojure.string/join "\n" (get-code-lines source)))

(defn get-result [source]
  (->> source
       (partition 2 ,,,)
       (map first ,,,)
       (map #(not= "-" %) ,,,)))

(facts "source 1 works"
  (get-non-comment-lines (get-code source-1)) => (get-result source-1))

(facts "source 2 works"
  (get-non-comment-lines (get-code source-2)) => (get-result source-2))



