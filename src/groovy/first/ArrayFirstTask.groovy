package first

/**
 * Created by Dmitry on 05.06.2017.
 */

class ArrayFirstTask {

    static Integer[] INT_ARRAY_ONE = [200, 300, 100, 200, 350, 500]
    static Integer[] INT_ARRAY_SECOND = [200, 300, -100, -200, 300, 500]

    static void main(String[] args) {
//        println getCountUniqueDigit()
//        println getMax(INT_ARRAY_ONE)
//        println getMin(INT_ARRAY_ONE)
//        println enlargeArray(INT_ARRAY_SECOND)
        println uniqueElememtInTwoList(INT_ARRAY_SECOND)
    }

    static def getCountUniqueDigit(Integer[] array) {
        (INT_ARRAY_ONE as List).toSet().size()
    }

    static def getMin(Integer[] array) {
        INT_ARRAY_ONE.min()
    }

    static def getMax(Integer[] array) {
        INT_ARRAY_ONE.max()
    }

    static def enlargeArray(Integer[] intArray) {
        def newArray = []
        intArray.each {
            if (it >= 0) {
                newArray << (it * 2)
            } else {
                newArray << (it * 3)
            }
        }
        newArray.toArray()
    }

    static def uniqueElememtInTwoList(Integer[] intArray) {
        //имеется второй массив неупорядоченных чисел: определить числа, входящие и в первый и во второй массив;
        def kkk = INT_ARRAY_SECOND as List
        kkk.retainAll(INT_ARRAY_ONE as Object[])
        kkk
    }
}