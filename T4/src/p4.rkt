#lang racket

(define-struct node (val left right) #:mutable #:transparent)

(define (agregar abb x)
  (cond
    [(null? (node-val abb)) (set-node-val! abb x)]
    [(and (< x (node-val abb)) (not(null? (node-left abb)))) (agregar (node-left  abb) x)]
    [(and (> x (node-val abb)) (not(null? (node-right abb)))) (agregar (node-right abb) x)]
    [(and (< x (node-val abb)) (null? (node-left abb))) (set-node-left! abb (node x '() '()))]
    [(and (> x (node-val abb)) (null? (node-right abb))) (set-node-right! abb (node x '() '()))]
   )
  )

(define (mostrar abb)
  (cond
    [(not(null? (node-val abb)))
      (cond
        [(and (not(null? (node-left abb))) (not(null? (node-right abb)))) (list (node-val abb) (mostrar (node-left abb)) (mostrar (node-right abb)))]
        [(and (not(null? (node-left abb))) (null? (node-right abb))) (list (node-val abb) (mostrar (node-left abb)) '())]
        [(and (null? (node-left abb)) (not(null? (node-right abb)))) (list (node-val abb) '() (mostrar (node-right abb)))]
        [else (list (node-val abb) '() '())]
       )
     ]
   )
  )

(define (buscar abb x)
  (cond
    [(= x (node-val abb)) #t]
    [(and (< x (node-val abb)) (not(null? (node-left abb)))) (buscar (node-left abb) x)]
    [(and (> x (node-val abb)) (not(null? (node-right abb)))) (buscar (node-right abb) x)]
    [(and (< x (node-val abb)) (null? (node-left abb))) #f]
    [(and (> x (node-val abb)) (null? (node-right abb))) #f]
   )
  )