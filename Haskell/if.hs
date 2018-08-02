sayHello name =
  if name=="Youer"
  then ("Hello,"++name)
  else "Who are you?"

greet :: [String] -> String

greet (x:xs) =
  if x=="Youer"
  then sayHello x 
  else greet (tail xs)
