package calculator

import java.util.*

 fun main(args: Array<String>) {
     val i = Scanner(System.`in`)
     while (true) {
         print("->")
         val s = i.nextLine()
         when (s) {
             "exit" -> return
             "help" -> printHelp()
             else -> Dicern(s)
         }
     }
 }
        fun printHelp() {
            println("""
        |使用前缀表达式,符号与第一个数字相连
        |(+ 1 1)
        |(* (+5 5) (/1 2))
    """.trimIndent())
        }


