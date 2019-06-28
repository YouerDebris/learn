(define point cons)
(define x car)
(define y cdr)

(define (point-plus pointa  pointb)
  (point (+ (x pointa) (x pointb))
         (+ (y pointa) (y pointb))))

(define (point-multi point_ factor)
  (point
   (* (x point_) factor)
   (* (y point_) factor)))

(define (trans point xp yp)
  (point-plus
   (point-multi xp (x point))
   (point-multi yp (y point))))
