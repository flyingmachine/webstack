(ns webstack.db.t-db-functions
  (:require [webstack.db.test :as tdb]
            [webstack.db.maprules :as mr]
            [flyingmachine.cartographer.core :as c]
            [webstack.db.query :as q])
  (:use midje.sweet
        webstack.controllers.test-helpers))

(setup-db-background)

(defn watch
  []
  (q/one [:watch/topic]))

(fact "increment-register"
  (q/t [[:increment-watch-count (-> (watch) :watch/topic :db/id) 1]])
  (:watch/unread-count (watch))
  => 1)
