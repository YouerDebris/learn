package calculator

import rubbish.Stack
import java.nio.file.Files
import java.nio.file.Path

class Discern {

    private var functions = hashMapOf<String,String>()
    private var stack = Stack<Char>()
    private var result = ""

    fun analyse(exp : String?) {
        if (exp == null) return
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

    fun analyse(paths: Path){
        Files.lines(paths).forEach { analyse(it) }
    }

     fun getResults() :String{
        //clear stack
        var string = ""
        while (stack.see() != null) {
            string = stack.get().toString() + string
        }
        return string
    }

    private fun put(char: Char){
        when(char){
            ')' -> count()
            else -> stack.push(char)
        }
    }

    private fun putFun(s:String) {
        functions[s.substring(0,s.indexOf('<'))] = s.substring(s.indexOf('<'))
    }

    private fun count(){
        val list:MutableList<Double> = mutableListOf()
        do {
            var digital = ""
            var char = stack.get()
            if (isDigit(char)){
                while (isDigit(char)){
                    digital = char.toString()+digital
                    if (isDigit(stack.see())) {
                        char = stack.get()
                    }else if (stack.see()=='-'){
                        stack.get()
                        list.add(-digital.toDouble())
                        break
                    }else {
                        list.add(digital.toDouble())
                        break
                    }
                        }
            }else if (char!='('){
                char?.let { number(list, it) }
            }
        }while (char !='(')
        for (char in result) {
            stack.push(char)
        }
        result = ""
    }

    private fun isDigit(char: Char?)= char in '0'..'9'||char=='.'

    private fun isLetter(char: Char?)= char in 'a'..'z'||char in 'A'..'Z'

    private fun number(list: MutableList<Double>, char:Char) {
        when(char){
            '+'-> add(list)
            '-'-> subtract(list)
            '*'-> multiply(list)
            '/'-> divide(list)
            else-> {
                if (isLetter(char)) {
                    stack.push(char)
                    function(list)
                }
            }
        }
    }

    private fun function(digital:MutableList<Double>){
        //fun:  [funName<var1,var2,>(+ (* var1 var2) (- var2 var1))]
        var s = ""
        while (isLetter(stack.see())){
            s = stack.get().toString() + s
        }
        val function = functions[s]
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
                    val discern = Discern()
                    discern.analyse(newFun?.substring(newFun.indexOf(">")+1))
                    result = discern.getResults()
                }
            }
        }else {
            error("function '$s' not found")
        }
    }

    private fun add(list: MutableList<Double>){
        result = list.sum().toString()
    }

    private fun subtract(list: MutableList<Double>){
        for (count in list.lastIndex-1 downTo 0){
            list[list.lastIndex] -= list[count]
        }
        result = list[list.lastIndex].toString()
    }

    private fun multiply(list: MutableList<Double>){
        for (count in list.lastIndex-1 downTo 0){
            list[list.lastIndex] *= list[count]
        }
        result = list[list.lastIndex].toString()
    }

    private fun divide(list: MutableList<Double>){
        for (count in list.lastIndex-1 downTo 0){
            list[list.lastIndex] /= list[count]
        }
        result = list[list.lastIndex].toString()
    }
}