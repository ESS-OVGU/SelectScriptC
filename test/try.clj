(ns try
  (:use [clojure.test] :reload)
  (:use [selectscript.vm] :reload)
  (:use [selectscript.core] :reload)
  (:use [macross] :reload))

;(run-tests)

(deftest try_array
  (let [env (vm:init 100 100 0)]
    (iss [1 2 3 4 5]    "a=[1,2,3,4,5]; ")
    (iss 1              "try(a[0], 6);  ")
    (iss 6              "try(a[10], 6); ")
    (iss 5              "try(a[-1], 6); ")
    (iss 1              "try(a[-5], 6); ")
    (iss 6              "try(a[-6], 6); ")
    (vm:exit env)))


(deftest try_fct
  (let [env (vm:init 100 100 0)]
    (iss 6 "try(f(1,2), 6);")
    (iss 6 "try(f(a), 6);  ")
    (vm:exit env)))


(deftest try_nested
  (let [env (vm:init 100 100 0)]
    (iss 5 "try(try(a, 5), 6);       ")
    (iss 6 "try(try(a, b), 6);       ")
    (iss 7 "try(try(a, try(b,7)), 6);")
    (vm:exit env)))


(deftest try_op
  (let [env (vm:init 100 100 0)]
    (iss [1 2 3 4 5]    "a=[1,2,3,4,5];")
    (iss [1 2 3 4 5]    "try(a*1, 6);  ")
    (iss 6              "try(a*a, 6);  ")
    (vm:exit env)))


(deftest try_var
  (let [env (vm:init 100 100 0)]
    (iss 6  "try(a,   6);   ")
    (iss 6  "try(a*b, 6);   ")
    (iss 6  "try(a@+(2), 6);")
    (vm:exit env)))
