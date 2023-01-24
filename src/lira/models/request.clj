(ns lira.models.request
  (:require [schema.core :as s]))

(s/defschema Request
  {:request/id          s/Uuid
   :request/json-params s/Str})