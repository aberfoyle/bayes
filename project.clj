(defproject bayes "0.1.0-SNAPSHOT"
  :description "A play project to get started with a Bayesian calculator and Clojure."
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0"]]
  :main ^:skip-aot bayes.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
