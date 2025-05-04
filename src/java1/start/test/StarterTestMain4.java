package java1.start.test;

import static java1.util.MyLogger.log;

public class StarterTestMain4 {
    public static void main(String[] args) {
        Thread threadA = new Thread(new PrintWork("A", 1000), "Thread-A");
        Thread threadB = new Thread(new PrintWork("B", 500), "Thread-B");

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
