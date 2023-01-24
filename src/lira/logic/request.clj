(ns lira.logic.request
  (:require [lira.models.request :as models.request]
            [schema.core :as s]))

(s/defn filepath :- s/Str
  [{:request/keys [id]} :- models.request/Request]
  (str "/tmp/" id ".json"))