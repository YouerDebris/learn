module Accumule where

import Data.Char

accum :: [Char] -> [Char]
accum str = tail (fun str 0)

fun :: [Char] -> Int -> [Char]
fun (x:xs) dig = '-':toUpper x:replicate dig (toLower x)++fun xs (dig+1)
fun _ _ = []
