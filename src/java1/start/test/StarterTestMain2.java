package java1.start.test;

import static java1.util.MyLogger.log;

public class StarterTestMain2 {
    public static void main(String[] args) {
        CounterRunnable runnable = new CounterRunnable();
        Thread thread = new Thread(runnable, "counter");
        thread.start();

    }

    static class CounterRunnable implements Runnable {
        @Override
        public void run() {
            for(int i = 1; i <= 5; i++){
                log("value: " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
