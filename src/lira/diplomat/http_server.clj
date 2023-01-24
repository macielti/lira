(ns lira.diplomat.http-server
  (:require [lira.diplomat.http-server.request :as diplomat.http-server.request]))

(def routes [["/api/request" :post [diplomat.http-server.request/log-request] :route-name :log-request]])
