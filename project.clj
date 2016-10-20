(defproject me.raynes/fs "1.4.6"
  :description "File system utilities for clojure"
  :license {:name "Eclipse Public License - v 1.0"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :url "https://github.com/Raynes/fs"
  :dependencies [[org.clojure/core.typed "0.3.29-SNAPSHOT"]
                 [org.clojure/clojure "1.9.0-alpha13"]
                 [org.apache.commons/commons-compress "1.8"]]
  :plugins [[lein-midje "3.2.1"]
            [codox "0.8.10"]]
  :codox {:src-dir-uri "https://github.com/Raynes/fs/blob/master/"
          :src-linenum-anchor-prefix "L"
          :defaults {:doc/format :markdown}}
  :deploy-repositories {"releases" :clojars}
  :injections [(require 'clojure.core.typed)
               (clojure.core.typed/install
                 #{:load})]
  :repl-options {:timeout 300000}
  :profiles {:dev {:dependencies [[midje "1.9.0-alpha5"
                                   :exclusions [marick/such]]
                                  [marick/suchwow "5.2.4"]]}})
