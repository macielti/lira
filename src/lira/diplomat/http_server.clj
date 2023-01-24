(ns lira.diplomat.http-server
  (:require #_[common-clj.component.telegram.consumer :as component.telegram.consumer]
            [lira.diplomat.telegram.consumer :as diplomat.telegram.consumer]
            [lira.diplomat.http-server.request :as diplomat.http-server.request]))

(def routes [#_["/api/handler" :post [(fn telegram-bot-handler
                                      [{update     :json-params
                                        components :components}]
                                      (component.telegram.consumer/consume-update! update diplomat.telegram.consumer/consumers components)
                                      {:status 200})] :route-name :telegram-bot-handler]
             ["/api/request" :post [diplomat.http-server.request/log-request] :route-name :log-request]])
