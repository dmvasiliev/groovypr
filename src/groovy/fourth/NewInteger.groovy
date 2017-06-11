package fourth

/**
 * Created by vasiliev on 6/6/2017.
 */
class NewInteger {
    static {
        Integer.metaClass.static.multiplyTwo = { a ->
            (a * 2) as Double
        }
    }

    public static void main(String[] args) {
        print Integer.multiplyTwo(40)
    }
}




