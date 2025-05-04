package java1.executor.poolsize;

import java1.executor.RunnableTask;

import java.util.concurrent.*;

import static java1.executor.ExecutorUtils.printState;
import static java1.util.MyLogger.log;

public class PoolSizeMainV2 {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(2);
//        ExecutorService es = new ThreadPoolExecutor(2, 2,
//                0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());

        log("pool 생성)");
        printState(es);

        for (int i = 1; i <= 6; i++) {
            String taskName = "task" + i;
            es.execute(new RunnableTask(taskName));
            printState(es, taskName);
        }
        es.close();
        log(" == shutdown 완료 == ");
    }
}
