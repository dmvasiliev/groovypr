package fifth

/**
 * Created by Dmitry on 08.06.2017.
 */
class TestMultiThreadSleep implements Runnable {
    String name

    TestMultiThreadSleep(String name) {
        this.name = name
    }

    static void main(String[] args) {
        Thread thread1 = new Thread(new TestMultiThreadSleep("A"))
        Thread thread2 = new Thread(new TestMultiThreadSleep("B"))
        Thread thread3 = new Thread(new TestMultiThreadSleep("C"))
        thread1.start()
        thread2.start()
        thread3.start()
    }

    void run() {
        println "${name} Step 1"
        sleep(3000)
        println "${name} Step 2"
        sleep(3000)
        println "${name} Step 3"
    }
}
