(set-env!
 :source-paths   #{"src"}
 :resource-paths #{"resources"}
 :dependencies '[[org.clojure/clojurescript     "1.9.946"]
                 [reagent                       "0.8.0-alpha2"]
                 [adzerk/boot-cljs              "2.1.4"  :scope "test"]
                 [pandeiro/boot-http            "0.7.3"  :scope "test"]
                 [powerlaces/boot-figreload     "0.5.14" :scope "test"]
                 [com.cemerick/piggieback       "0.2.1"  :scope "test"]
                 [weasel                        "0.7.0"  :scope "test"]
                 [org.clojure/tools.nrepl       "0.2.13" :scope "test"]
                 [binaryage/devtools            "0.9.9" :scope "test"]
                 [binaryage/dirac               "1.2.25" :scope "test"]
                 [powerlaces/boot-cljs-devtools "0.2.0" :scope "test"]])

(require '[adzerk.boot-cljs :refer [cljs]]
         '[pandeiro.boot-http :refer [serve]]
         '[powerlaces.boot-cljs-devtools :refer [cljs-devtools dirac]])

(deftask dev []
  (comp (watch)
        (cljs-devtools :ids #{"app"})
        (dirac :ids #{"app"})
        (cljs :ids #{"app"}
              :optimizations :none
              :source-map true
              :compiler-options {:npm-deps {:react "16.0.0"
                                            :react-dom "16.0.0"
                                            :create-react-class "15.6.2"}
                                 :install-deps true})
        (serve)))
