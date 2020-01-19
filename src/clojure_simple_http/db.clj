(ns clojure-simple-http.db
  (:require [clj-postgresql.core :as pg]
            [clojure.java.jdbc :as jdbc]))

(defn- password
  "`pg/env-spec` doesn't contain PGPASSWORD. They prefer to look up ~/.pgpass instead,
  because of PG authors concern https://www.postgresql.org/docs/current/static/libpq-envars.html."
  []
  (get (System/getenv) "PGPASSWORD"))

(defn- dbname
  []
  (get (System/getenv) "PGDATABASE" "postgres"))

(def db (pg/spec :dbname (dbname)))
