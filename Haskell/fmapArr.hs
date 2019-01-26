instance Functor [] where
  
  fmap f (x:xs) = f x:fmap f xs
  fmap _ [] = []
