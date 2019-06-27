(display
 (combine 1))

(define (composite f fu)
  (lambda (x)
    (f (fu x))))

(define combine (lambda (x)
                  ((composite 1- 1+)
                   x)))
