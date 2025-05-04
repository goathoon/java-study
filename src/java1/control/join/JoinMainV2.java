package java1.control.join;

import static java1.util.MyLogger.log;
import static java1.util.ThreadUtils.sleep;

public class JoinMainV2 {
    public static void main(String[] args) {
        log("Start");
        JoinMainV1.SumTask task1 = new JoinMainV1.SumTask(1, 50);
        JoinMainV1.SumTask task2 = new JoinMainV1.SumTask(51, 100);
        Thread thread1 = new Thread(task1, "thread-1");
        Thread thread2 = new Thread(task2, "thread-2");

        thread1.start();
        thread2.start();

        // 정확한 타이밍 맞추지 x
        log("main 스레드 sleep");
        sleep(3000);
        log("main 스레드 깨어남");

        log("task1.result = " + task1.result);
        log("task2.result = " + task2.result);

        int sumAll = task1.result + task2.result;
        log("task1 + task2 = " + sumAll);

        log("End");
    }

    static class SumTask implements Runnable {
        int startValue;
        int endValue;
        int result;

        public SumTask(int startValue, int endValue) {
            this.startValue = startValue;
            this.endValue = endValue;
        }

        @Override
        public void run() {
            log("작업 시작");
            sleep(2000);
            int sum = 0 ;
            for(int i = startValue; i <= endValue; i++){
                sum += i;
            }
            result = sum;
            log("작업 완료 result = " + result);
        }
    }
}
