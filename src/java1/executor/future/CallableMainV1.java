package java1.executor.future;

import java.util.Random;
import java.util.concurrent.*;

import static java1.util.MyLogger.log;
import static java1.util.ThreadUtils.sleep;

public class CallableMainV1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(1);
        Future<Integer> future = es.submit(new MyCallabe());
        Integer result = future.get();
        log("result value = "+ result);
        es.close();
    }

    static class MyCallabe implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            log("Callable 시작");
            sleep(2000);
            int result = new Random().nextInt(10);
            log("create value = " + result);
            log("Callable 완료");
            return result;
        }
    }

}
