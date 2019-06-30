(define (make-set list)
  (if (null? list)
      '()
      (let (
            (head [car list])
            (tail [cdr list]))
        (if [element-of-set head tail]
            (make-set tail)
            (cons head [make-set tail])))))
  
(define (element-of-set element set)
  (cond
   ((null? set) #f)
   ((equal? element [car set]) #t)
   (else (element-of-set element [cdr set]))))
