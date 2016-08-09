(ns selectscript.parser
    (:use [selectscript.defines] :reload)
    (:import (org.antlr.v4.runtime CommonTokenStream
                                   ANTLRInputStream)
             (org.antlr.v4.runtime.tree Tree
                                        ParseTree
                                        ParseTreeWalker
                                        ParseTreeVisitor)
             (S2 SelectScriptLexer
                 SelectScriptParser
                 SelectScriptBaseVisitor)))

;(use 'clojure.tools.trace)
;(trace-ns 'selectscript.parser)

(declare -atom
         -assign
         -dict
         -dict_elem
         -dict_id
         -element
         -exit
         -function
         -if_expr
         -list
         -loc
         -loop
         -procedure
         -prog
         -selection
         -sel_as
         -sel_connect
         -sel_dir
         -sel_list
         -sel_order
         -set
         -special
         -special2
         -stmt
         -stmt_list
         -try_expr
         -value
         -variable

         parse
         parseInt
         visitor
         visit)

(defmacro expr [op two]
  (list 'list :op op
         (let [param1 '(visit (.e1 ctx))]
           (if (= 2 two)
             (let [param2 '(visit (.e2 ctx))]
               (list 'list param1 param2))
             (list 'list param1)))))

(def visitor
  (proxy [SelectScriptBaseVisitor] []
    (visitAssign      [ctx] (expr :assign   2))
    (visitAtom        [ctx] (-atom        ctx))
    (visitDict        [ctx] (-dict        ctx))
    (visitDict_elem   [ctx] (-dict_elem   ctx))
    (visitDict_id     [ctx] (-dict_id     ctx))
    (visitElement     [ctx] (-element     ctx))
    (visitExit        [ctx] (-exit        ctx))
    (visitFunction    [ctx] (-function    ctx))
    (visitIf_expr     [ctx] (-if_expr     ctx))
    (visitList        [ctx] (-list        ctx))
    (visitLoc         [ctx] (-loc         ctx))
    (visitLoop        [ctx] (-loop        ctx))
    (visitProcedure   [ctx] (-procedure   ctx))
    (visitProg        [ctx] (-prog        ctx))
    (visitSelection   [ctx] (-selection   ctx))
    (visitSel_as      [ctx] (-sel_as      ctx))
    (visitSel_connect [ctx] (-sel_connect ctx))
    (visitSel_dir     [ctx] (-sel_dir     ctx))
    (visitSel_list    [ctx] (-sel_list    ctx))
    (visitSel_order   [ctx] (-sel_order   ctx))
    (visitSet         [ctx] (-set         ctx))
    (visitSpecial     [ctx] (-special     ctx))
    (visitSpecial2    [ctx] (-special2    ctx))
    (visitStmt        [ctx] (-stmt        ctx))
    (visitStmt_list   [ctx] (-stmt_list   ctx))
    (visitTry_expr    [ctx] (-try_expr    ctx))
    (visitValue       [ctx] (-value       ctx))
    (visitVariable    [ctx] (-variable    ctx))

    (visitEx_ex       [ctx] (expr :ex    1))
    (visitEx_not      [ctx] (expr :not   1))
    (visitEx_pos      [ctx] (expr :pos   1))
    (visitEx_neg      [ctx] (expr :neg   1))
    (visitEx_pow      [ctx] (expr :pow   2))
    (visitEx_div_mod_mul [ctx]
        (list :op
              (cond
                (.DIV ctx) :div
                (.MOD ctx) :mod
                (.MUL ctx) :mul)
              (list (visit (.e1 ctx))
                    (visit (.e2 ctx)))))
    (visitEx_add_sub  [ctx]
        (list :op
          (if (.ADD ctx)
            :add
            :sub)
          (list (visit (.e1 ctx))
                (visit (.e2 ctx)))))
    (visitEx_shift    [ctx]
        (list :op
          (if (.SHIFTL ctx)
            :left
            :right)
          (list (visit (.e1 ctx))
                (visit (.e2 ctx)))))
    (visitEx_iand     [ctx] (expr :iand  2))
    (visitEx_ixor     [ctx] (expr :ixor  2))
    (visitEx_ior      [ctx] (expr :ior   2))
    (visitEx_inot     [ctx] (expr :inot  1))
    (visitEx_lt       [ctx] (expr :lt    2))
    (visitEx_le       [ctx] (expr :le    2))
    (visitEx_ge       [ctx] (expr :ge    2))
    (visitEx_gt       [ctx] (expr :gt    2))
    (visitEx_ne       [ctx] (expr :ne    2))
    (visitEx_in       [ctx] (expr :in    2))
    (visitEx_eq       [ctx] (expr :eq    2))
    (visitEx_and      [ctx] (expr :and   2))
    (visitEx_xor      [ctx] (expr :xor   2))
    (visitEx_or       [ctx] (expr :or    2))))



(defn visit [ctx]
  (.visit visitor ctx))


(defn parse [string]
  (let [tree (.prog
               (SelectScriptParser.
                 (CommonTokenStream.
                   (SelectScriptLexer.
                     (ANTLRInputStream. string)))))]
    (visit tree)))


(defn cutString [string]
    (subs string 1 (- (count string) 1)))


(defn parseInt
  "convert a string to int"
  [string]
  (defn del0 [string]
    (if (not= (first string) \0)
      string
      (recur (subs string 1))))

  (if (< (count string) 2)
      (Integer/parseInt string)
    (case (subs string 0 2)
      "0b" (Integer/parseInt (del0 (subs string 2)) 2)
      "0o" (Integer/parseInt (del0 (subs string 2)) 8)
      "0x" (Integer/parseInt (del0 (subs string 2)) 16)
      (Integer/parseInt (del0 string)))))


(defn -atom [ctx]
  (if-let [elem (.elem_ ctx)]
    (visit elem)
    (.visitChildren visitor ctx)))

(defn children
  ([ctx start]
   (children ctx start (.getChildCount ctx)))
  ([ctx i max]
   (if (< i max)
     (lazy-seq
       (cons
         (let [elem (visit (.getChild ctx i))]
           (if (string? elem)
             (ss:val (if (not= (first elem) "\"")
                       (if (not= (first elem) "'")
                         elem)
                       (cutString elem)))
             elem))
         (children ctx (inc i) max))))))


(defn -dict [ctx]
  (ss:dict (map -dict_elem (.elem_ ctx))))


(defn -dict_elem [ctx]
  {(-dict_id (.id_ ctx)),
   (visit (.value_ ctx))})


(defn -dict_id [ctx]
  (if-let [id (.id_ ctx)]
    (.getText id)
    (cutString (.getText (.str_ ctx)))))


(defn -element [ctx]
  (ss:elem
    (if-let [var (.var_ ctx)]
      (-variable var)
      (if-let [stmt (.stmt_ ctx)]
        (-stmt stmt)
        (-loc  (.loc_ ctx))))
    (remove nil? (children ctx 2))))

(defn -exit [ctx]
  (ss:exit (if-let [exit (.stmt ctx)]
             (-stmt exit)
             (ss:var nil))))


(defn -function [ctx]
  (ss:fct (visit (.repo_ ctx))
          (if-let [elem (.elem_ ctx)]
            (-stmt_list elem)
            ())))


(defn -if_expr [ctx]
  (ss:if (-stmt (.if_ ctx))
         (if-let [then (.then_ ctx)]
          (-stmt then)
          (ss:val true))
        (if-let [else (.else_ ctx)]
          (-stmt else)
          (ss:val false))))


(defn -list [ctx]
  (ss:list (if-let [elem (.elem_ ctx)]
             (-stmt_list elem)
             ())))


(defn -loop [ctx]
  (ss:loop (-stmt (.do_ ctx))))


(defn -loc [ctx]
  (ss:loc (if-let [id (.id_ ctx)]
            (.getText id)
            "")
          (if-let [extra (.extra_ ctx)]
            (-stmt extra)
            ())))


(defn -procedure [ctx]
  (ss:proc (let [params (map #(.getText %) (.id_ ctx))]
             (if (.loc_ ctx)
               (cons "" params)
               params))
           (-stmt (.code_ ctx))
           (if (.info_ ctx)
             (cutString (.getText (.info_ ctx)))
             "")))


(defn -prog [ctx]
  (map visit (.elem_ ctx)))


(defn -set [ctx]
  (ss:set (if-let [elem (.elem_ ctx)]
            (-stmt_list elem)
            (list))))

(defn -selection [ctx]
  (let [select  (.select_  ctx)  from  (.from_    ctx)
        where   (.where_   ctx)  start (.start_   ctx)
        connect (.connect_ ctx)  stop  (.stop_    ctx)
        group   (.group_   ctx)  order (.order_   ctx)
        limit   (.limit_   ctx)  as    (.as_      ctx)]
    (merge
      {:from (visit from)}
      (if select
        {:select  (visit select)})
      (if where
        {:where   (visit where)})
      (if start
        {:start   (visit start)})
      (if connect
        {:connect (-sel_connect connect)})
      (if stop
        {:stop    (visit stop)})
      (if group
        {:group   (visit  group)})
      (if order
        {:order   (-sel_order   order)})
      (if limit
        {:limit   (visit  limit)})
      (if as
        (-sel_as as)
        {:as :list}))))

(defn -sel_as [ctx]
    {:as (let [as (.getText (.IDENTIFIER ctx))]
           (case (clojure.string/lower-case as)
             "dict"         :dict
             "dictionary"   :dict
             "list"         :list
             "val"          :val
             "value"        :val
             "void"         :void
             (as)))})

(defn -sel_dir [ctx]
    (if (.ASC ctx) 0 1))

(defn -sel_list [ctx]
    (remove nil? (children ctx 0)))

(defn -special [ctx]
  (let [params (-stmt_list (.elem_ ctx))
        op (cond
             (.EQ       ctx) :eq
             (.NE       ctx) :ne
             (.LE       ctx) :le
             (.GE       ctx) :ge
             (.LT       ctx) :lt
             (.GT       ctx) :gt
             (.ADD      ctx) :add
             (.SUB      ctx) :sub
             (.MUL      ctx) :mul
             (.DIV      ctx) :div
             (.MOD      ctx) :mod
             (.POW      ctx) :pow
             (.IN       ctx) :in
             (.AND      ctx) :and
             (.OR       ctx) :or
             (.XOR      ctx) :xor
             (.IAND     ctx) :iand
             (.IXOR     ctx) :ixor
             (.IOR      ctx) :ior
             (.INV      ctx) :inv
             (.SHIFTR   ctx) :right
             (.SHIFTL   ctx) :left)]

    (if (and
          (= 1 (count params))
          (or (= op :sub)
              (= op :add))
          (not (get params :fct))
          (not= (get (first params) :op) :ex))
      (ss:op (if (= op :sub)
              :neg
              :pos)
            params)
      (list :op op params))))


(defn -special2 [ctx]
  (let [op   (-special (.op_ ctx))
        repo (visit (.repo_ ctx))]
    (ss:opX (case (second op)
              :neg :sub
              :pos :add
              (second op))
            (cons repo (last op)))))


(defn -stmt [ctx]
  (if-let [seq (.seq_ ctx)]
        (-prog seq)
        (.visitChildren visitor ctx)))


(defn -try_expr [ctx]
  (ss:try (-stmt (.try_ ctx))
          (if (.catch_ ctx)
            (-stmt (.catch_ ctx))
            (ss:val nil))))


(defn -stmt_list [ctx]
  (map visit (.elem_ ctx)))


(defn -value [ctx]
  (ss:val (cond
            (.true_  ctx) true
            (.false_ ctx) false
            (.none_  ctx) nil
            (.int_   ctx) (parseInt (.getText ctx))
            (.float_ ctx) (read-string (.getText ctx))
            (.str_   ctx) (cutString (.getText ctx)))))


(defn -variable [ctx]
  (ss:var (.getText ctx)))
