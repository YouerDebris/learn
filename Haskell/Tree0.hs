module Tree0 where

import Tree
import Data.List

balance :: Ord a => [a] -> Tree a
balance [] = Nil
balance list = Node (head rh) (balance lf) (balance (drop 1 rh))
  where 
    l = sort list
    t = splitList
    lf = fst t
    rh = snd t
    splitList = splitAt ((length l) `div` 2) l

search :: Ord a => Tree a -> a -> Bool
search Nil _ = False
search tree v
  |v > (value tree) = search (left tree) v
  |v < (value tree) = search (right tree) v
  |otherwise = True
