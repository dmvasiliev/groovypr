package seventh

import java.util.concurrent.CountDownLatch
import java.util.concurrent.Executors

/**
 * Created by Dmitry on 08.06.2017.
 */
class ThreadClacc {


    public static void main(String[] args) {
        def pool = Executors.newFixedThreadPool(2)

        int taskCount = 10000;
        def countDownLatch = new CountDownLatch(taskCount);

        taskCount.times { n ->
            def action = {
                def x = 0;
                sleep(100);
                x++;
                println "${n} ${x}";
                countDownLatch.countDown()
            } as Runnable;
            pool.submit(action);
        }

        countDownLatch.await()

        println("finished");
    }

}
