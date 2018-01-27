(ns dirac-repro.core
  (:require [reagent.core :as reagent]
            [dirac-repro.as-aliased :as as-aliased]
            [dirac-repro.with-refer :refer [the-referred-thing]]
            [dirac-repro.views :refer [app]]))

(defn ^:export init []
  (js/console.log "init")
  (as-aliased/some-func :foo)
  (the-referred-thing :bar)
  (reagent/render [app] (.getElementById js/document "root")))
