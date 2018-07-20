package calculator

class Dicern (s:String){

    var stack = Stack<Char>()
    var final = 0.0

    init {
        for (letter in s) {
            put(letter)
        }
        println("-> $final")
    }

    fun put(char: Char){
        when(char){
            ')' -> count()
            else -> stack.push(char)
        }
    }

    fun count(){
        var digital = ""
        var list:MutableList<Double> = mutableListOf()
        do {
            var char = stack.get()
            if (isDigital(char)){
                w@while ( isDigital(char)){
                    digital = char.toString()+digital
                    if (isDigital(stack.see())) {
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
            }else if (!isDigital(char)&&char!='('){
                number(list,char)
                digital=""
            }
        }while (char !='(')
        for (char in final.toString().toCharArray())
            stack.push(char)
    }

    fun isDigital(char: Char?)=
            char=='0'||
            char=='1'||
            char=='2'||
            char=='3'||
            char=='4'||
            char=='5'||
            char=='6'||
            char=='7'||
            char=='8'||
            char=='9'||
            char=='.'

    fun number(list: MutableList<Double>,char:Char?) {
        when(char){
            '+'-> add(list)
            '-'-> subtract(list)
            '*'-> multiply(list)
            '/'-> divide(list)
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
      for (digital in list){
          final*=digital
      }
    }

    fun divide(list: MutableList<Double>){
        final = list[list.lastIndex]
      for (count in list.lastIndex-1 downTo 0){
          final /= list[count]
      }
    }
}