module Maskify where

maskify :: String -> String
maskify str@(x:xs)
  |length str <= 4 = str
  |otherwise = '#':maskify xs
maskify _ = []
