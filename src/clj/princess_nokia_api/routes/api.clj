(ns princess-nokia-api.routes.api
  (:require [compojure.core :refer [defroutes GET]]
            [ring.util.http-response :refer :all]
            [compojure.api.sweet :refer [context]]
            [amazonica.aws.s3 :refer [list-objects]]
            [amazonica.aws.s3transfer]))

(defn get-objects-from-aws-s3 [_]
  (let [objs (list-objects :bucket-name "princess-nokia")]
    (ok {:princess-nokia (:object-summaries objs)})))

(defroutes api-routes
           (context "/api" []
                    (GET "/music" [] get-objects-from-aws-s3)))