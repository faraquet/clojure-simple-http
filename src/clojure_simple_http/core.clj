(ns clojure-simple-http.core
  (:require [org.httpkit.server :refer [run-server]]
            [clj-time.core :as t]
            [clj-postgresql.core :as pg]
            [clojure.java.jdbc :as jdbc]
            ))


(defn- password
  "`pg/env-spec` doesn't contain PGPASSWORD. They prefer to look up ~/.pgpass instead,
  because of PG authors concern https://www.postgresql.org/docs/current/static/libpq-envars.html."
  []
  (get (System/getenv) "PGPASSWORD"))

(def db (pg/pool :host "localhost" :user "faraquet" :dbname "hb"))

(defn app [req]
  {:status  200
   :headers {"Content-Type" "text/html"}
   :body    (jdbc/query db ["select current_time::char(8)"])})

(defn -main [& args]
  (run-server app {:port 8080})
  (println "Server started on port 8080"))
