fun main(args : Array<String>){
	println("Hello,World")
	Fib(0,1)
	println("Byebye,World")
}

fun isFib(vararg args: Int):Boolean{
    for (i in args.indices)
        if (i <= args.size-3&&args[i]+args[i+1]!=args[i+2])
            return false
    return true
}

fun Fib(a:Int,b:Int){
	var c = a+b
	if(c<0)return
	println("$a,")
	Fib(b,c)
}

