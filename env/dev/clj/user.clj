(ns user
  (:require [mount.core :as mount]
            princess-nokia-api.core))

(defn start []
  (mount/start-without #'princess-nokia-api.core/repl-server))

(defn stop []
  (mount/stop-except #'princess-nokia-api.core/repl-server))

(defn restart []
  (stop)
  (start))


