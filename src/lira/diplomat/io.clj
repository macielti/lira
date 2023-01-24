(ns lira.diplomat.io
  (:require [schema.core :as s]
            [lira.models.request :as models.request]
            [lira.logic.request :as logic.request]
            [cheshire.core :as json]))

(s/defn save-to-file
  [request :- models.request/Request]
  (->> (json/encode request)
       (spit (logic.request/filepath request))))