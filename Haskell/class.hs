class  Eq a  where
 (==), (/=) :: a -> a -> Bool

    -- Minimal complete definition:
    --     (==) or (/=)
 x /= y     =  not (x == y)
 x == y     =  not (x /= y)
