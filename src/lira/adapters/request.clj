(ns lira.adapters.request
  (:require [schema.core :as s]
            [lira.models.request :as models.request]))

(s/defn wire->request :- models.request/Request
  [{:keys [json-params]}]
  {:request/id          (random-uuid)
   :request/json-params json-params})
