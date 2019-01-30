main = do
  str <- getLine
  let int = read str::Int
  print  (solve int 0)

solve :: Int -> Int -> Int
solve 1 count = count
solve int count
  |even int = solve (int `div` 2) count+1
  |otherwise = solve ((3 * int + 1) `div` 2) count+1
