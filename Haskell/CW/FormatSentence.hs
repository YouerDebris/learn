module FormatSentence where

formatWords :: [String] -> String
formatWords = solve . filter (\x -> x /= "")

solve [] = ""
solve (x:[]) = x
solve (x:xs:[]) = (x ++ " and " ++ xs)
solve (x:xs) = (x ++ ", " ++ solve xs)
