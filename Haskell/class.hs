class Youer a where
  (+),(-) :: a -> a -> a
  (==),(!=) :: a -> a -> Bool

  x == y = not (x != y)
  x != y = not (x == y)
