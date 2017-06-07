package fifth

/**
 * Created by vasiliev on 6/7/2017.
 */
class EnclosedInInnerClass {
    class Inner {
        Closure cl = { this }
    }
    void run() {
        def inner = new Inner()
        assert inner.cl() == inner
    }
}