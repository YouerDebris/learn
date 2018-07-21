package calculator

class Dicern {

    var functions = hashMapOf<String,String>()
    var stack = Stack<Char>()
    var final = 0.0

    fun analyss(exp : String?) {
        if (exp != null) {
            var count = 0
            while (count in exp.indices) {
                if (exp[count] == '[') {
                    putFun(exp.substring(exp.indexOf('[') + 1, exp.indexOf(']')))
                    count += exp.substring(0,exp.indexOf(']') + 1).length
                } else {
                    put(exp[count])
                }
                count++
            }
        }
    }

     fun getResults() :String{
        //clear stack
        var string = ""
        while (stack.see() != null) {
            string = stack.get().toString() + string
        }
        return string
    }

    fun put(char: Char){
        when(char){
            ')' -> count()
            else -> stack.push(char)
        }
    }

    private fun putFun(s:String) {
        functions.put(s.substring(0,s.indexOf('<')),s.substring(s.indexOf('<')))
    }

    fun count(){
        var digital = ""
        var list:MutableList<Double> = mutableListOf()
        do {
            var char = stack.get()
            if (isDigit(char)){
                w@while (isDigit(char)){
                    digital = char.toString()+digital
                    if (isDigit(stack.see())) {
                        char = stack.get()
                    }else if (stack.see()=='-'){
                        stack.get()
                        list.add(-digital.toDouble())
                        break@w
                    }else {
                        list.add(digital.toDouble())
                        break@w
                    }
                        }
            }else if (char!='('){
                number(list,char)
                digital=""
            }
        }while (char !='(')
        for (char in final.toString()) {
            stack.push(char)
        }
        final = 0.0
    }

    fun isDigit(char: Char?)= char in '0'..'9'||char=='.'

    fun isLetter(char: Char?)= char in 'a'..'z'||char in 'A'..'Z'

    fun number(list: MutableList<Double>,char:Char?) {
        when(char){
            '+'-> add(list)
            '-'-> subtract(list)
            '*'-> multiply(list)
            '/'-> divide(list)
            '|'-> function(list)
        }
    }

    fun function(digital:MutableList<Double>){
        //fun:  [funName<var1,var2,>(+ (* var1 var2) (- var2 var1))]
        var s = ""
        while (isLetter(stack.see())){
            s = stack.get().toString() + s
        }
        var function = functions.get(s)
        if (function != null) {
            var count = 0
            var varNumber = 0
            var newFun = function
            while (count in function.indices) {
                if (function[count++] == '<') {
                    var variable = ""
                    while (function[count] != '>') {
                        if (function[count] == ',') {
                            newFun = newFun?.replace(variable,digital[digital.lastIndex-varNumber].toString(),false)
                            variable =""
                            varNumber++
                        }else{
                            variable += function[count]
                        }
                        count++
                    }
                    var dicern = Dicern()
                    dicern.analyss(newFun?.substring(newFun.indexOf(">")+1))
                    final = dicern.getResults().toDouble()
                }
            }
        }else {
            error("function '$s' not found")
        }
    }

    fun add(list: MutableList<Double>){
      for (digital in list){
          final+=digital
      }
    }

    fun subtract(list: MutableList<Double>){
        final = list[list.lastIndex]
      for (count in list.lastIndex-1 downTo 0){
          final -= list[count]
      }
    }

    fun multiply(list: MutableList<Double>){
        final = list[list.lastIndex]
      for (count in list.lastIndex-1 downTo 0){
          final*= list[count]
      }
    }

    fun divide(list: MutableList<Double>){
        final = list[list.lastIndex]
      for (count in list.lastIndex-1 downTo 0){
          final /= list[count]
      }
    }
}