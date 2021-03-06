(ns princess-nokia-api.handler
  (:require [compojure.core :refer [routes wrap-routes]]
            [princess-nokia-api.layout :refer [error-page]]
            [princess-nokia-api.routes.home :refer [home-routes]]
            [compojure.route :as route]
            [princess-nokia-api.env :refer [defaults]]
            [mount.core :as mount]
            [princess-nokia-api.middleware :as middleware]
            [princess-nokia-api.routes.api :refer [api-routes]]))

(mount/defstate init-app
                :start ((or (:init defaults) identity))
                :stop  ((or (:stop defaults) identity)))

(def app-routes
  (routes
    #'api-routes
    (-> #'home-routes
        (wrap-routes middleware/wrap-csrf)
        (wrap-routes middleware/wrap-formats))
    (route/not-found
      (:body
        (error-page {:status 404
                     :title "page not found"})))))


(defn app [] (middleware/wrap-base #'app-routes))
