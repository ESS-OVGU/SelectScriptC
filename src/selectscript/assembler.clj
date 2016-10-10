(ns selectscript.assembler
  (:use [selectscript.compiler :only (OP op)]  :reload))

(declare assemble
         asm
         asm:dict
         asm:elem
         asm:exit
         asm:fct
         asm:if
         asm:list
         asm:loc
         asm:loop
         asm:op
         asm:opX
         asm:proc
         asm:recur
         asm:ref
         asm:sql
         asm:sql_as
         asm:sql_from
         asm:sql_select
         asm:sql_where
         asm:sql_order
         asm:sql_group
         asm:sql_limit
         asm:try
         asm:set
         asm:val
         asm:var

         optimize
         seq:loop
         pop:add
         pop:rm)

(def as_value {:void 0 :val 1 :list 2 :set 4 :dict 3})

(defn optimize
  ([code]       (optimize code []))
  ([code opt]   (if (empty? code)
                  opt
                  (case (first code)
                    [:STORE     :POP] (if (and (= [:LOAD] (nth code 2))
                                               (= (nth code 1) (nth code 3)))
                                        (optimize (nthrest code 3)
                                                  (concat opt '((:STORE))))
                                        (optimize (rest code)
                                                  (concat opt [(first code)])))
                    [:STORE_LOC :POP] (if (and (= [:LOC] (nth code 2))
                                               (= (nth code 1) (nth code 3)))
                                        (optimize (nthrest code 3)
                                                  (concat opt '((:STORE_LOC))))
                                        (optimize (rest code)
                                                  (concat opt [(first code)])))

                    (optimize   (rest code) (concat opt [(first code)]))))))



(defn assemble [ast]
  (asm ast false))

(defn asm [ast pop]
  (case (first ast)
    :dict   (asm:dict  (second ast) pop)
    :elem   (asm:elem  (rest ast)   pop)
    :exit   (asm:exit  (second ast) pop)
    :fct    (asm:fct   (rest ast)   pop)
    :if     (asm:if    (rest ast)   pop)
    :list   (asm:list  (second ast) pop)
    :loc    (asm:loc   (rest ast)   pop)
    :loop   (asm:loop  (second ast) pop)
    :op     (asm:op    (rest ast)   pop)
    :opX    (asm:opX   (rest ast)   pop)
    :proc   (asm:proc  (rest ast)   pop)
    :recur  (asm:recur (second ast) pop)
    :ref    (asm:ref   (second ast) pop)
    :set    (asm:set   (second ast) pop)
    :sql    (asm:sql   (rest ast)   pop)
    :try    (asm:try   (rest ast)   pop)
    :val    (asm:val   (second ast) pop)
    :var    (asm:var   (second ast) pop)

    (concat '((:SP_SAVE))
            (seq:loop ast true)
            (if pop
              '((:RET :POP))
              '((:RET))))))


(defn asm:dict [dict pop]
  (concat (seq:loop (map second dict) false)
          (list (if pop
                  '(:CST_DCT :POP)
                  '(:CST_DCT))
                (map first dict))))

(defn asm:elem [[p1 p2] pop]
  (concat (asm p1 false)
          (loop [elems [] code p2]
            (if (= 1 (count code))
              (concat elems
                      (asm (first code) false)
                      (if pop
                        '((:ELEM :POP))
                        '((:ELEM))))
              (recur (concat elems
                             (asm (first code) false)
                             '((:ELEM)))
                     (rest code))))))

(defn asm:exit [ast pop]
  (concat (asm ast false)
          '((:EXIT))))

(defn asm:fct [[id params] pop]
  (let [param_count (count params)]
    (concat (if (zero? param_count)
              ()
              (seq:loop params false))
            (asm id false)
            (if pop
              '((:CALL_FCT :POP))
              '((:CALL_FCT)))
            (list (count params)))))

(defn asm:if [[if_ then_ else_] pop]
  (let [asm_if   (asm if_   false)
        asm_then (asm then_ pop)
        asm_else (asm else_ pop)]
    (if (= 0
           (count asm_then)
           (count asm_else))
      (asm if_ true)
      (concat asm_if   '((:IF))
              asm_then '((:RET_X))
              asm_else '((:RET_X))))))

(defn asm:loop [ast pop]
  (concat '((:LOOP_BEGIN))
          (if (list? (first ast))
            (seq:loop ast true)
            (asm ast true))
          '((:RET_X))))

(defn asm:list [ast pop]
  (concat (if (not-empty ast)
            (seq:loop ast false)
            ())
          (list (if pop
                  '(:CST_LST :POP)
                  '(:CST_LST))
                (count ast))))

(defn asm:loc [[id extension] pop]
  (if (not pop)
    (if (empty? extension)
      (list '(:LOC) id)
      (concat (asm extension false)
              (list '(:LOCX) id)))))

(defn asm:op [[op params] pop]
  (if (= op :assign)
    (case (first (first params))
      :var  (concat (seq:loop (rest  params) false)
                    (if pop
                      '((:STORE :POP))
                      '((:STORE)))
                    [(second (first params))])
      :loc  (concat (seq:loop (rest  params) false)
                    (if pop
                      '((:STORE_LOC :POP))
                      '((:STORE_LOC)))
                    [(second (first params))])
      :elem (concat (asm (first params) false)
                    (seq:loop (rest  params) false)
                    (if pop
                      '((:STORE_RF :POP))
                      '((:STORE_RF)))))
    (concat (seq:loop params false)
            (list (if pop
                    '(:CALL_OP :POP)
                    '(:CALL_OP))
                  op
                  (dec (count params))))))

(defn asm:opX [[op params] pop]
  (concat (seq:loop params false)
          (list (if pop
                  '(:CALL_OPX :POP)
                  '(:CALL_OPX))
                op
                (dec (count params)))))

(defn asm:proc [[params code info] pop]
  (if (not pop)
    (concat (asm params false)
            '((:PROC))
            [info]
            [(concat '((:SP_SAVE))
                    (if (list? (first code))
                      (seq:loop code true)
                      (asm code false))
                    '((:RET_P)))])))

(defn asm:recur [ast _]
  (concat (seq:loop ast false)
          ['(:CST_LST) (count ast)]
          '((:RECUR))))

(defn asm:ref [ast pop]
  (if (not pop)
    (concat (asm ast false) '((:REF)))))

(defn asm:set [ast pop]
  (if (not pop)
    (concat (if (not-empty ast)
              (seq:loop ast false)
              ())
            (list '(:CST_SET) (count ast)))))

(defn asm:sql [[from select where start connect stop group order limit as] pop]
  (with-local-vars [asm '((:SP_SAVE))]
    (let [FROM    (asm:sql_from      from)
          SELECT  (asm:sql_select    select)
          WHERE   (asm:sql_where     where)
          START   (if (not-empty start)
                    (seq:loop start true)
                    ())
          CONNECT ()
          STOP    ()
          ORDER   (asm:sql_order     order)
          LIMIT   (asm:sql_limit     limit)]
      (let [AS    (asm:sql_as        as (second SELECT))
            GROUP (asm:sql_group     group (second SELECT))]
        (var-set asm (concat @asm FROM))
        (var-set asm (concat @asm '((:IT_INIT))))

        (var-set asm (concat @asm START))

        (if (and (= as :val)
                 (= () WHERE GROUP))
          (var-set asm (concat @asm
                               '((:IT_NEXT0))
                               (first SELECT)
                               '((:IT_AS) 1)))
          (if (and (= as :val)
                   (empty GROUP)
                   (not-empty WHERE))
            (var-set asm (concat @asm
                                 AS
                                 '((:IT_NEXT0))
                                 '((:FJUMP_FW_X) 2)
                                 WHERE
                                 (first SELECT)
                                 '((:IT_AS) 1)
                                 '((:RET_X))))
            (if (and (not= as :val)
                     (= () GROUP ORDER LIMIT))
              (var-set asm (concat @asm
                                   AS
                                   '((:IT_NEXT0))
                                   '((:FJUMP_BK_X) 5 -5)
                                   WHERE
                                   (first SELECT)
                                   (list '(:IT_AS) (as as_value))
                                   '((:RET_X))))
              (var-set asm (concat @asm
                                   '((:IT_NEXT0))
                                   '((:FJUMP_BK_X) 5 -5)
                                   WHERE
                                   '((:IT_STORE))
                                   LIMIT
                                   '((:RET_X))
                                   ORDER
                                   AS
                                   (if (= :val as)
                                     '((:IT_NEXT1))
                                     '((:IT_NEXT3) (:FJUMP_BK_X) 5 -5))
                                   (first SELECT)
                                   (list '(:IT_AS) (as as_value))
                                   (if (= :val as)
                                     ()
                                     '((:RET_X)))
                                   GROUP)))))

        (var-set asm (concat @asm (if pop
                                    '((:RET :POP))
                                    '((:RET)))))
        @asm))))

(defn asm:sql_as [type ids]
  (case type
    :set    (list '(:CST_SET) 0)
    :dict   (concat (loop [i ids asm ()]
                      (if (empty? i)
                        asm
                        (recur (rest i)
                               (concat asm (list '(:CST_LST) 0)))))
                    (list '(:CST_DCT) ids))
    :list   (list '(:CST_LST) 0)
    :val    '((:CST_N))
    :void   '((:CST_N))))


(defn asm:sql_from [elements]
  (with-local-vars [expr (), ids ()]
    (loop [elem elements]
      (var-set ids  (concat @ids  [(first elem)]))
      (var-set expr (concat @expr (asm (second elem) false)))
      (let [next_elems (nthrest elem 2)]
        (if (not-empty next_elems)
          (recur next_elems))))
    (concat @expr '((:CST_DCT)) (list @ids))))

(defn asm:sql_select [elements]
  (with-local-vars [expr (), ids ()]
    (loop [elem elements]
      (var-set ids  (concat @ids  [(first elem)]))
      (var-set expr (concat @expr (asm (second elem) false)))
      (let [next_elems (nthrest elem 2)]
        (if (not-empty next_elems)
          (recur next_elems))))
    [@expr @ids]))

(defn asm:sql_where [ast]
  (if (empty? ast)
    ()
    (concat '((:FJUMP_WHERE))
            (asm ast false)
            '((:RET_X)))))

(defn asm:sql_limit [ast]
  (if (empty? ast)
    ()
    (concat (asm ast false)
            '((:IT_LIMIT)))))

(defn asm:sql_group [ast, ids]
  (if (empty? ast)
    ()
    (concat '((:CST_DCT) ())
            '((:IT_NEXT3))
            '((:FJUMP_BK_X) 5 -5)
            (asm ast false)
            (list '(:IT_GROUP) (count ids))
            '((:RET_X)))))

(defn asm:sql_order [ast]
  (loop [elem ast rslt ()]
    (if (empty? elem)
      rslt
      (let [[expr dir] (first elem)
            asm_expr (asm expr false)]
        (concat rslt
                '((:CST_0))
                '((:IT_ORDER))
                '((:FJUMP_BK_X) 5 -5)
                '((:IT_NEXT1))
                asm_expr
                '((:IT_NEXT2))
                asm_expr
                '((:CALL_OP))
                (if (= dir :asc)
                  '(:LT 1)
                  '(:GT 1))
                '((:RET_X)))))))

(defn asm:try [[ast1 ast2] pop]
  (concat '((:SP_SAVE))
          '((:TRY_1))
          (asm ast1 false)
          '((:RET_X))
          (asm ast2 false)
          '((:RET_X))
          (if pop
            '((:RET :POP))
            '((:RET)))))

(defn asm:val [val pop]
  (if (not pop)
    (cond
      (nil?     val)  '((:CST_N))
      (false?   val)  '((:CST_0))
      (true?    val)  '((:CST_1))
      (integer? val)  (if (and (< -127 val) (> 127 val))
                        (list '(:CST_B) val)
                        (if (and (< -32767 val) (> 32767 val))
                          (list '(:CST_S) val)
                          (list '(:CST_I) val)))
      (float?   val)  (list '(:CST_F) val)
      (string?  val)  (list '(:CST_STR) val))))

(defn asm:var [ast pop]
  (if (not pop)
    (list '(:LOAD) ast)))

(defn seq:loop [ast pop]
  (loop [from ast, to '()]
    (if (= 1 (count from))
      (concat to (asm (first from) false))
      (recur (rest from)
             (concat to
                     (asm (first from) pop))))))

;(asm (parse "f(); f();"))
