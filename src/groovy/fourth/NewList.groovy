package fourth

/**
 * Created by vasiliev on 6/6/2017.
 */
class NewList {
    static {
        List.metaClass.printAllList = { c, d ->
            println("${delegate}    ${c}     ${d}")
        }
    }
}
