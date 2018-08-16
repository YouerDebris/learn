import java.util.*

 fun main(args: Array<String>) {
     val i = Scanner(System.`in`)
     val dicern = Discern()
     //dicern.analyse(Paths.get("calculator/src/calculator/xxx"))
     while (true) {
         print("->")
         val s = i.nextLine()
         when (s) {
             "exit" -> return
             "help" -> printHelp()
             else -> {
                 dicern.analyse(s)
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
        |定义函数:[funName<var1,var2,...,>(exp)]
        |(每个变量后面都得加','    XD
        |调用函数:(funName ...)
    """.trimIndent())
        }


