(ns lira.components
  (:require [common-clj.component.config :as component.config]
            [com.stuartsierra.component :as component]
            [common-clj.component.service :as component.service]
            [common-clj.component.routes :as component.routes]
            [lira.diplomat.http-server :as diplomat.http-server]))

(def system-prod
  (component/system-map
    :config (component.config/new-config "resources/config.edn" :prod :edn)
    :routes (component/using (component.routes/new-routes diplomat.http-server/routes) [:config])
    :service (component/using (component.service/new-service) [:routes :config])))

(defn start-system! []
  (component/start system-prod))

(def system-test
  (component/system-map
    :config (component.config/new-config "resources/config.example.edn" :test :edn)
    :routes (component/using (component.routes/new-routes diplomat.http-server/routes) [:config])
    :service (component/using (component.service/new-service) [:routes :config])))
