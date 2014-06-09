(ns ldn-clj-june-deis.test.handler
  (:use clojure.test
        ring.mock.request  
        ldn-clj-june-deis.handler))

(deftest test-app
  (testing "main route"
    (let [response (app (request :get "/"))]
      (is (= (:status response) 200))
      (is (= (:body response) "Hello World"))))
  
  (testing "not-found route"
    (let [response (app (request :get "/invalid"))]
      (is (= (:status response) 404)))))
