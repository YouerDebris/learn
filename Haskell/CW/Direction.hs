module Codewars.Kata.Reduction where

data Direction = North | East | West | South deriving (Eq,Show)

waste :: Direction -> Direction
waste North = South
waste East = West
waste West = East
waste South = North

dirReduce :: [Direction] -> [Direction]
dirReduce [] = []
dirReduce xs@(x:[]) = xs
dirReduce (x:y:ys)
  |waste x == y = dirReduce ys
  |otherwise =
     if length ys + 2 > length next
     then dirReduce next
     else next
   where
     next = x : dirReduce (y : ys)
