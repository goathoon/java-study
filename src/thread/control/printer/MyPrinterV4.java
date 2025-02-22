 package thread.control.printer;

import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;

import static thread.util.MyLogger.log;

public class MyPrinterV4 {
    public static void main(String[] args) {
        Printer printer = new Printer();
        Thread printerThread = new Thread(printer, "printer");
        printerThread.start();

        Scanner userInput = new Scanner(System.in);
        while(true) {

            log("프린터할 문서를 입력하세요. 종료 (q):");
            String input = userInput.nextLine();
            if (input.equals("q")) {
                printerThread.interrupt();
                break;
            }
            printer.addJob(input );
        }

    }

    static class Printer implements Runnable{
        Queue<String> jobQueue = new   ConcurrentLinkedQueue<>();

        @Override
        public void run() {
            while(!Thread.interrupted()) {
                try {
                    /*
                     이전에 jobQueue empty체크를 안하긴 했네..
                     하지만 이렇게 jobQueue가 비어있는 상태를 계속 체크한다면..
                     많은 스레드가 동시에 스케줄링 될때,
                     time slice만큼 계속 CPU를 사용하는 꼴이 되므로 의미없는 CPU 사용이되어버림
                     해당 경우에는 yield를 사용해서 다른 스레드에게 우선권을 넘기는게 좋다.
                     */
                    if(jobQueue.isEmpty()) {
                        Thread.yield();
                        continue;
                    }

                    String job = jobQueue.poll();
                    log("출력 시작: " + job + ", 대기 문서: " + jobQueue);
                    Thread.sleep(3000);
                    log("출력 완료");
                } catch (InterruptedException e) {
                    log("인터럽트!");
                    break;
                }
            }
            log("프린터 종료");
        }

        public void addJob(String input) {
            jobQueue.offer(input);
        }
    }
}
