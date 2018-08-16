module Tree where

data Tree value = Node value (Tree value) (Tree value)|Nil
    deriving(Show,Eq)

value (Node v _ _) = v
--first :: (Tree t -> a) -> Tree t -> a
--first :: Tree a -> [b]

first Nil = []
first tree = value tree++first (left tree)++first (right tree)
  where
    left (Node _ value _) = value
    right (Node _ _ value) = value