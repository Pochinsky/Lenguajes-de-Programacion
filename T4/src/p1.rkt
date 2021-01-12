#lang racket

;;(tipos_help L1)
;;genera la lista de letras según tipo de número con una lista vacía como último elemento.
;;entrega una lista de letras E, R o C dependiendo de la lista de números entregadas y de último elemento tiene una lista vacía.
(define (tipos_help L1)
  (cond
    [(null? L1) '()]
    [(integer? (car L1)) (cons 'E (tipos_help (cdr L1)))]
    [(real? (car L1)) (cons 'R (tipos_help (cdr L1)))]
    [(complex? (car L1)) (cons 'C (tipos_help (cdr L1)))]
   )
  )

(define (tipos L1)
  (remove '() (tipos_help L1))
 )