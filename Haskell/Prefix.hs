module Prefix where

calculate :: String -> Float
calculate = head . foldr fun [] . words
  where
    fun "+" (x:y:ys) = (x+y):ys
    fun "-" (x:y:ys) = (x-y):ys
    fun "*" (x:y:ys) = (x*y):ys
    fun "/" (x:y:ys) = (x/y):ys
    fun token xs = read token:xs
