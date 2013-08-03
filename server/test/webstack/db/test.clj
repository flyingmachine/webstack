(ns webstack.db.test
  (:require [datomic.api :as d]
            [webstack.db.query :as q]
            [webstack.db.manage :as manage])
  (:use webstack.config)
  (:import java.io.File))

(def test-db-uri (config :datomic :test-uri))
(def initialized (atom false))

(defmacro with-test-db
  [& body]
  `(binding [q/*db-uri* test-db-uri]
     (initialize)
     ~@body))

(defn initialize
  []
  (doall (manage/reload)))
