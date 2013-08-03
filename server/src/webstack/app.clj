(ns webstack.app
  (:gen-class)
  (:require [webstack.server :as server]
            [webstack.db.manage :as db]))

(defn -main
  [cmd]
  (cond 
   (= cmd "server") (server/-main)
   (= cmd "db/reload") (do (println (db/reload)) (System/exit 0))
   (= cmd "db/migrate") (do (println (db/migrate)) (System/exit 0))))
