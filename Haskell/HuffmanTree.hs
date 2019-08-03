module HuffmanTree where
{-
data Tree value = HNode value (HTree value) (HTree value) Weights|Nil
  (deriving Eq,Show)

instance Ord HTree where
  compare _ Nil = GT
  compare Nil _ = LT
  compare (HNode _ _ weight1) (HNode _ _ weight2) = weight1 `compare` weight2
-}

import Tree
import Data.List

createHTree :: Ord o => [a] -> [o] -> Tree a
createHTree [] _ = Nil
createHTree values weights
  |(length values) == (length weights) = hTree $ sortList values weights
  |otherwise = Nil

data Weight a b = WPair a b

wValue (WPair v _) = v
weight (WPair _ w) = w

sortOrd (WPair _ a) (WPair _ b)
  |a > b = LT
  |a < b = GT
  |a == b = EQ

bindWeight [] [] = []
bindWeight (x:xs) (y:ys) = (WPair x y) :bindWeight xs ys

sortList values weights = map wValue $ sortBy sortOrd $ bindWeight values weights

hTree [] = Nil
hTree (x:list) = Node x (hTree lf) (hTree rt)
  where
    lf = single list
    single (y:z:zs) = y:(single zs)
    single (y:[]) = y:[]
    single [] = []
    rt = double list
    double (y:z:zs) = z:(double zs)
    double (y:[]) = []
    double [] = []