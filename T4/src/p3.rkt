#lang racket

;;(menor L)
;;obtener el menor numero de la lista L
;;entrega el numero correspondiente al menor elemento de L
(define (menor L)
  (do ((lista L (cdr lista))
       (min 10000 (if(< (car lista) min) (car lista) min)))
      ((empty? lista) min)
   )
 )

(define (merge L1 L2)
  (do ((out '() (cons (menor L3) out))
       (L3 (append L1 L2) (remove (menor L3) L3)))
       ((empty? L3) (reverse out))
       )
   )