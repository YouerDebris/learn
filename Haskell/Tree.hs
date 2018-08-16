module Tree where

data Tree value  =
  Node value (Tree value) (Tree value)
  |Empty
    deriving(Show)

--while f tree =  
