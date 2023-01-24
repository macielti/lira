(ns lira.diplomat.http-server.request
  (:require [schema.core :as s]
            [lira.adapters.request :as adapters.request]
            [lira.controllers.request :as controllers.request]))

(s/defn log-request
  [{{:keys [config]} :components :as wire-request}]
  (-> (adapters.request/wire->request wire-request)
      (controllers.request/log-request! config))
  {:status 202})