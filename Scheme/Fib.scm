(define (fib a b c)
     (cond
      [ ( > c 0) (display a) (display "\n") (fib b (+ a b) (- c 1))]
      [(= c 0) (display a) (display "\n")]))
