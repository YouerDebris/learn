module MoleculeToAtoms where

parseMolecule :: String -> Either String [(String,Int)]
parseMolecule formula@(x:xs)
  |(last answer) /= ("Error",0) = Right answer
  |otherwise = Left "Not a valid molecule"
  where
    answer = elemStream $ seperation formula

seperation :: [Char] -> [[Char]]
seperation [] = [[]]
seperation (x:xs) = (x:(fst pair)):(seperation $ snd pair)
  where
    pair = span notSepSymbol xs
    notSepSymbol '(' = False
    notSepSymbol ')' = False
    notSepSymbol '[' = False
    notSepSymbol ']' = False
    notSepSymbol '{' = False
    notSepSymbol '}' = False
    notSepSymbol x = notElem x ['A'..'Z']

parseSingle :: String -> (String,Int)
parseSingle singleElem = (fst pair,number $ snd pair)
  where
    pair = span (\x -> notElem x ['1'..'9']) singleElem
    number [] = 1
    number x = read x::Int

bind :: (String,Int) -> [(String,Int)] -> [(String,Int)]
bind pair [] = pair:[]
bind pair (x:xs)
  |(fst pair) == elemName = (elemName,(snd x)+(snd pair)):xs
  |otherwise = x:(bind pair xs)
  where
    elemName = fst x

notFormula [] = True
notFormula (x:xs) = notElem x ['A'..'Z']

matchSymbol "(" = ")"
matchSymbol "[" ="]"
matchSymbol "{" = "}"
                    
elemChecker :: [(String,Int)] -> [(String,Int)]
elemChecker [] = []
elemChecker (x:xs)
  |elem elemName ["(","[","{"] = mutiply xs [] (matchSymbol elemName)
  |elem elemName [")","]","}"] = x:xs
  |elemName == "" = elemChecker xs
  |notFormula elemName = mutiply [] [] []
  |otherwise = x:(elemChecker xs)
  where
    elemName = fst x

mutiply :: [(String,Int)] -> [(String,Int)] -> String -> [(String,Int)]
mutiply [] _ _ = [("Error",0)]
mutiply (x:xs) list symbol
  |elemName == symbol = (map (\pair -> (fst pair,(snd pair) * (snd x))) list) ++ (elemChecker xs)
  |elem elemName [")","]","}"] = mutiply [] [] []
  |elem elemName ["(","[","{"] = mutiply (mutiply xs [] (matchSymbol elemName)) list symbol
  |elemName == "" = mutiply xs list symbol
  |notFormula elemName = mutiply [] []  []
  |otherwise = mutiply xs (list++[x]) symbol
  where
    elemName = fst x

elemStream list = foldl (\x y -> bind y x) [] (elemChecker $ map parseSingle list)
