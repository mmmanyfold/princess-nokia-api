(ns princess-nokia-api.env
  (:require [selmer.parser :as parser]
            [clojure.tools.logging :as log]
            [princess-nokia-api.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (log/info "\n-=[princess-nokia-api started successfully using the development profile]=-"))
   :stop
   (fn []
     (log/info "\n-=[princess-nokia-api has shut down successfully]=-"))
   :middleware wrap-dev})
