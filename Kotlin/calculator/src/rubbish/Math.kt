package rubbish

object Math {

    fun average(digital:Array<Double>):Double{
        var d = 0.0
        for (dig in digital)
            d+=dig
        return d/digital.size
    }

    fun variance(digital: Array<Double>):Double{
        val ave = average(digital)
        var d = 0.0
        for (dig in digital)
            d+=(dig-ave)*(dig-ave)
        return d/digital.size
    }

    fun factorial(digit:Int):Int{
        return if (digit>1) factorial(digit-1) else digit
    }

}