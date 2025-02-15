package thread.start.test;

import static thread.util.MyLogger.log;

public class StarterTestMain1 {
    public static void main(String[] args) {
        CounterThread thread = new CounterThread();
        thread.start();
    }

    static class CounterThread extends Thread {
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
