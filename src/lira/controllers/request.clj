(ns lira.controllers.request
  (:require
    [clojure.java.io :as io]
    [schema.core :as s]
    [lira.models.request :as models.request]
    [lira.diplomat.io :as diplomat.io]
    [lira.diplomat.telegram.producer :as diplomat.telegram.producer]
    [lira.logic.request :as logic.request]))

(s/defn log-request!
  [request :- models.request/Request
   {:keys [telegram] :as config}]
  (diplomat.io/save-to-file request)
  (-> (logic.request/filepath request)
      io/file
      (diplomat.telegram.producer/send-document! (:chat-id telegram) (:token telegram)))
  (-> (logic.request/filepath request)
      clojure.java.io/delete-file))