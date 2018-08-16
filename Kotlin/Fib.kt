object Fib {

    fun isFib(args: Array<Int>): Boolean {
        for (i in args.indices) {
            if (i <= args.size - 3 && args[i] + args[i + 1] != args[i + 2]) {
                return false
            }
        }
        return true

    }

    fun fib(a: Int, b: Int) {
        val c = a + b
        if (c < 0) return
        else{
        println("$a,")
        fib(b, c)
        }
    }
}