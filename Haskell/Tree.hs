module Tree where

data Tree value = Node value (Tree value) (Tree value)|Nil
    deriving(Show,Eq)

fac value = Node value Nil Nil

value (Node v _ _) = v
left (Node _ value _) = value
right (Node _ _ value) = value

first Nil = []
first tree = value tree:first (left tree)++first (right tree)

second Nil = []
second tree = second (left tree)++value tree:second (right tree)

third Nil = []
third tree = third (left tree)++third (right tree)++value tree:[]
