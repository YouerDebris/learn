myMap :: (a -> b) -> [a] -> [b]

myMap fun (x:xs) = fun x:myMap fun xs

myMap _ [] = []
