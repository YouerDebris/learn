package calculator

import java.util.*

 fun main(args: Array<String>) {
     val i = Scanner(System.`in`)
     while (true) {
         print("->")
         val s = i.nextLine()
         val dicern = Dicern()
         when (s) {
             "exit" -> return
             "help" -> printHelp()
             else -> {
                 dicern.analyss(s)
                 println(dicern.getResults())
             }
         }
     }
 }
        fun printHelp() {
            println("""
        |使用前缀表达式
        |(+ 1 1)
        |(* (+5 5) (/1 2))
    """.trimIndent())
        }


