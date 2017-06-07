package fifth

/**
 * Created by vasiliev on 6/7/2017.
 */
class NestedClosures {
    void run() {
        def nestedClosures = {
            def cl = { this }
            cl()
        }
        assert nestedClosures() == this
    }
}