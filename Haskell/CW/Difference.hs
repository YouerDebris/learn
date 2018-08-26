module Difference where

difference :: Eq a => [a] -> [a] -> [a]
difference a b = filter (\d -> notElem d b) a
