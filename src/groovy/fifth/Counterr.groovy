package fifth

import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

/**
 * Created by vasiliev on 6/8/2017.
 */
class Counterr implements Runnable {
    private static final Integer NUMBER_THREADS = 10
    private Integer number = 0;

    void workOnCounter() {
        synchronized (this) {
            number++
        }
        println("Thread nasme ${Thread.currentThread().name}, number=${number} ")
    }

    public void run() {
        workOnCounter();

        try {
            println("Thread ${Thread.currentThread().name} falls asleep for 100 millis")
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Runnable counter = new Counterr();
        ExecutorService executor = Executors.newFixedThreadPool(NUMBER_THREADS);
        for (int i = 0; i < NUMBER_THREADS; i++) {
            executor.execute(counter);
        }
//        executor.shutdown();
//        while (!executor.isTerminated()) {
//        }
    }
}
