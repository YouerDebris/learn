module Codewars.Triangles where

import Data.List (sort)

isTriangle :: Int -> Int -> Int -> Bool
isTriangle a b c = (tmin a b c)>(maxT a b c)

tmin a b c
  |a<=0||b<=0||c<=0 = -1000
  |c>b&&c>a = a+b
  |b>c&&b>a = a+c
  |otherwise = c+

maxT a b c = max (max a b) (max b c)
