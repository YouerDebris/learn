module Codewars.G964.Countdig where

nbDig :: Int -> Int -> Int
nbDig n d
  |d==0 = (sum $ map (\a -> same a 0) k)+1
  |otherwise = sum $ map (\a -> same a 0) k
  where
    k = map (\a -> a*a) [0..n]
    et = truncate . (/10) . fromIntegral
    same dig acc
      |dig <= 0 = acc
      |rem dig 10 == d = same (et dig) acc+1
      |otherwise = same (et dig) acc
