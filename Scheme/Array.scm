(define (List index)
  (cond
   ((= index 0) '())
   (else (cons 0 (List (1- index))))))

(define (index arr)
  (define (index-c array count)
    (cond
     ((null? array) count)
     (else (index-c (cdr array) (1+ count)))))
  (index-c arr 0))

(define start 1)

(define (get arr index)
  (cond
   ((or (null? arr) (< index start))  (display "out of index"))
   ((= index start) (car arr))
   ((> index start) (get (cdr arr) (1- index)))))

(define (set arr index elemt)
  (cond
   ((or (null? arr) (< index start))  (display "out of index"))
   ((= index start) (cons elemt (cdr arr)))
   ((> index start) (cons (car arr) (set (cdr arr) (1- index) elemt)))))
