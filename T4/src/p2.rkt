#lang racket

;;(suma L)
;;hace la suma de todos los numeros contenidos en L.
;;entrega el numero correspondiente a la suma de los numeros contenidos en L.
(define(suma L)
  (if(null? L)
     0
     (+ (suma (cdr L)) (car L))
  )
)

(define (periS lados)
  (suma lados)
)

(define (periC lados)
  (if(null? lados)
     0
     (+ (car lados) (periC (cdr lados))
   )
  )
 )