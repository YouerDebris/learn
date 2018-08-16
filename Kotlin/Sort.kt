class Sort {

    fun insertSort(list:Array<Int>){
        list.sort(1,1)
        for (index in list.indices){
            var count = index-1
            val key = list[index]
            while (count>=0&&key<list[count]){
                list[count+1]=list[count]
                count--
            }
            list[count+1]=key
        }
    }

    fun mergeSort(list: Array<Int>, fromIndex:Int, toIndex:Int){
        fun merge(list: Array<Int>, first:Int, mid:Int, last:Int){
            val size1 = mid - first
            val size2 = last - mid + 1
            val l = arrayOfNulls<Int>(size1+1)
            val r = arrayOfNulls<Int>(size2+1)
            for (i in 0 until size1)
                l[i]=list[first+i]
            for (i in 0 until size2)
                r[i]=list[mid+i]
            l[size1] = Int.MAX_VALUE
            r[size1] = Int.MAX_VALUE
            var count1 = 0
            var count2 = 0
            for (i in first..last){
                val digit1 = l[count1]
                val digit2 = r[count2]
                if (digit1!! <= digit2!!){
                    list[i] = digit1
                    count1++
                }else{
                    list[i] = digit2
                    count2++
                }
            }
        }
        if (fromIndex<toIndex){
            val goIndex = (fromIndex+toIndex)/2
            mergeSort(list,fromIndex,goIndex)
            mergeSort(list,goIndex+1,fromIndex)
            merge(list,fromIndex,goIndex,toIndex)
        }
    }
}