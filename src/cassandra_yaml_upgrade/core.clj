(ns cassandra-yaml-upgrade.core
  (:gen-class)
  (:require [clj-yaml.core :as yaml])
  (:require [clojure.set :as set]))

(defn read-config [path]
  (yaml/parse-string (slurp path)))

(defn write-config [path config]
  (spit path (yaml/generate-string config 
                                   :dumper-options {:flow-style :block})))

(defn merge-config [old-config new-config path]
  (write-config path 
                (select-keys (merge new-config old-config) 
                             (keys new-config))))

(defn -main [old-yaml new-yaml destination]
  (merge-config (read-config old-yaml) (read-config new-yaml) destination))
