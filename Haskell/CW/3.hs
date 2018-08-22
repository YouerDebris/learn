module Kata (highAndLow) where

import Data.List

highAndLow :: String -> String
highAndLow input = (show (last list)++" "++show (head list))
  where
    clist = words input
    ilist = map readInt clist
    list = sort ilist
    readInt str = read str :: Int
