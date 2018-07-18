import java.util.*

fun main(args : Array<String>){
    println("Hello,World")
    println("What's  your name?")
    val sc = Scanner(System.`in`)
    val name = sc.nextLine()
    println("Oh,Let you see what is the Fibonacci sequence.")
    fib(0,1)
    println("Now,$name.Are you  konw what is the Fibonacci sequence?Print one let me see!")
    println("Enter the Fibonacci sequence and enter '-1' as the end marker")
    var list : MutableList<Int> = mutableListOf()
    var i : Int
    while(true){
        i = sc.nextInt()
        list.add(if (i!=-1) i else break)
    }
    if (isFib(list.toTypedArray())) println("Yes,You understand what is the Fibonacci sequence!")
    else println("That's not a Fibonacci sequence.$name")
}



fun isFib(args: Array<Int>):Boolean{
    for (i in args.indices)
        if (i <= args.size-3&&args[i]+args[i+1]!=args[i+2])
            return false
    return true
}

fun fib(a:Int,b:Int){
    val c = a+b
    if(c<0)return
    println("$a,")
    fib(b,c)
}