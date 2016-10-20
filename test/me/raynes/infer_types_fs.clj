(ns me.raynes.infer-types-fs
  (:use clojure.test)
  (:require [clojure.core.typed :as t]
            [clojure.core.typed.runtime-infer :as infer]))

(defn delete-anns [nss]
  (doseq [ns nss]
    (infer/delete-generated-annotations
      ns
      {:ns ns})))

(defn infer-anns [nss]
  (doseq [ns nss]
    (t/runtime-infer :ns ns)))

(def infer-files
  '[me.raynes.fs
    ])

;; FIXME shouldn't need this, but some types
;; don't compile
(delete-anns infer-files)

(def tests 
  '[me.raynes.core-test
    ])

(apply require tests)
(apply run-tests tests)

(infer-anns infer-files)

