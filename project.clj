(defproject clojure-simple-http "0.1.0-SNAPSHOT"
  :author "Andrey Andriychuk"
  :description "A simple HTTP server"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [http-kit "2.3.0"]
                 [clj-time "0.15.2"]
                 [clj-postgresql "0.7.0"]]
  :repl-options {:init-ns clojure-simple-http.core}
  :plugins [[lein-ring "0.12.5"]]
  :ring {:handler clojure-simple-http.core/handler}
  :main clojure-simple-http.core)
