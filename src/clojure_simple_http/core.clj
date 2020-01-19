(ns clojure-simple-http.core
  (:require [org.httpkit.server :refer [run-server]]
            [clojure.java.jdbc :as jdbc]
            [clojure-simple-http.db :as database]
            [compojure.core :refer :all]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [clojure.java.io :as io]))

(defroutes site-routes
  (GET "/" [] database/get-time)
  (context "/users/:user-id" [user-id]
           (GET "/" [] user-id))
  (route/not-found "Not found"))

(def handler
  (routes (handler/site site-routes)))

