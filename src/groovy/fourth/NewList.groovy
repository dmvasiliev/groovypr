package fourth

/**
 * Created by vasiliev on 6/6/2017.
 */
class NewList {
    static {
        List.metaClass.printAllList = { c, d ->
            print("${delegate}    ${c}     ${d}")
        }
    }

    public static void main(String[] args) {
        def list1 = new ArrayList<String>()
        list1 << "a"
        list1 << "b"
        list1 << "c"

        def list2 = new ArrayList<String>()
        list2 << "а"
        list2 << "б"
        list2 << "в"

        def list3 = new ArrayList<String>()
        list3 << "1"
        list3 << "2"
        list3 << "3"

        list3.printAllList(list1, list2)
    }
}
