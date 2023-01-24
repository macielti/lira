(ns lira.diplomat.telegram.producer
  (:require [morse.api :as morse-api]
            [schema.core :as s]))

(s/defn send-document! :- s/Str
  [file
   chat-id :- s/Str
   token :- s/Str]
  (morse-api/send-file token chat-id {} file "/sendDocument" "document" "document"))