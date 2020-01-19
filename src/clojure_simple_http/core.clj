(ns clojure-simple-http.core
  (:require [org.httpkit.server :refer [run-server]]
            [clojure.java.jdbc :as jdbc]
            [clojure-simple-http.db]))

(defn handler [req]
  {:status  200
   :headers {"Content-Type" "text/html"}
   :body    (jdbc/query clojure-simple-http.db/db ["select current_time::char(8)"])})
