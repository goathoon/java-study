package java1.control.interrupt;

import static java1.util.MyLogger.log;
import static java1.util.ThreadUtils.sleep;

public class ThreadStopMainV3 {
    public static void main(String[] args) {
        MyTask task = new MyTask();
        Thread thread = new Thread(task, "work");
        thread.start();

        sleep(4000);
        log("작업 중단 지시 thread.interrupt()");
        thread.interrupt();
        log("work 스레드 인터럽트 상태1 = " + thread.isInterrupted());
    }
    static class MyTask implements Runnable {
        @Override
        public void run() {
            while(!Thread.currentThread().isInterrupted()) {
                log("작업 중");
            }
            log("work 스레드 인터럽트 상태2 = " + Thread.currentThread().isInterrupted());

            //interrupt상태에서 sleep해야하는 로직이 존재할 경우 문제가 생김

            try{
                log("자원 정리");
                Thread.sleep(1000);
                log("자원 종료");
            } catch (InterruptedException e) {
                // 이미 interrup상태이므로 바로 interrupt 예외 터짐
                log("자원 정리 실패 - 자원 정리 중 인터럽트 발생");
                log("work 스레드 인터럽트 상태 3 = " + Thread.currentThread().isInterrupted());
            }
            log("자원 종료");
        }
    }
}
