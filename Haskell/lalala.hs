data Tea = Tea {
  teaName :: String,
  time :: Int
               }

ctea tea time'  = time tea  <= time'

dtea time = Tea "RedTea" time

link = ctea . dtea 

