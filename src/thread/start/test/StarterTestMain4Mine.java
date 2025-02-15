package thread.start.test;

import static thread.util.MyLogger.log;

public class StarterTestMain4Mine {
    public static void main(String[] args) {
        Thread threadA = new Thread(() -> {
            try {
                while(true) {
                    log("A");
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "Thread-A");

        Thread threadB = new Thread(() -> {
            log("B");
            try {
                while(true){
                    log("B");
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "Thread-B");

        threadA.start();
        threadB.start();
    }


    static class PrintWork implements Runnable {

        private String content;
        private int sleepMs;

        PrintWork(String content, int sleepMs) {
            this.content = content;
            this.sleepMs = sleepMs;
        }

        @Override
        public void run() {
            try {
                while(true){
                    log(content);
                    Thread.sleep(sleepMs);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
