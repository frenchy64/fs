(ns me.raynes.test-with-specs-fs
  (:require [me.raynes.fs :as m]
            [clojure.test :as test]
            [midje.repl :as repl]
            [clojure.spec.test :as stest]))

(defn activate-specs []
  (stest/instrument 
    (filter (comp #{'me.raynes.fs} symbol namespace)
            (stest/instrumentable-syms))))

(println "Activated specs:\n" (activate-specs))
(println "To prove specs are actually enabled, here is a bad call to (copy+ nil nil)")
(println
  (try (m/copy+ nil nil)
       (catch Throwable e e)))

(prn "The above lines should show a spec error from a bad call to (copy+ nil nil)")

(require 'me.raynes.core-test :reload)
