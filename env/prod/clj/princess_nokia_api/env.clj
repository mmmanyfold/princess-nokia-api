(ns princess-nokia-api.env
  (:require [clojure.tools.logging :as log]))

(def defaults
  {:init
   (fn []
     (log/info "\n-=[princess-nokia-api started successfully]=-"))
   :stop
   (fn []
     (log/info "\n-=[princess-nokia-api has shut down successfully]=-"))
   :middleware identity})
