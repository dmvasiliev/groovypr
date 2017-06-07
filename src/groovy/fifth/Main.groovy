package fifth

/**
 * Created by Dmitry on 08.06.2017.
 */
class Main {
    public static void main(String[] args) {
        def util = new Util()
        def tc1 = Thread.start {
            100.times {
                util.workOnCounter()
                sleep 20
                util.workOnList()
                sleep 10
            }
        }
//        def tc2 = Thread.start {
//            100.times {
//                util.workOnCounter()
//                sleep 10
//                util.workOnList()
//                sleep 15
//            }
//        }
    }
}
