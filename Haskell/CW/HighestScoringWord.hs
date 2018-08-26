module High.JorgeVS.Kata where

import Data.Array

high :: String -> String
high [] = ""
high myStr = highS s (sc f) f
  where
    str = words myStr
    f = head str
    s = tail str
    
highS (x:xs) big acc
  |b>big = highS xs b x
  |otherwise = highS xs big acc
  where
    b = sc x
highS [] _ acc = acc 

sc :: [Char] -> Int
sc (x:xs) = 1 + (index ('a','z') x) + sc xs
sc [] = 0
