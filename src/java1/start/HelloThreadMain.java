package java1.start;

public class HelloThreadMain {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + ": main() start");

        HelloThread helloThread = new HelloThread();
        System.out.println(Thread.currentThread().getName() + ": start() 호출 전");
        // run 바로 호출하면 안됨!! -> main: run()이 나옴. 즉, 메인스레드가 시작한다는뜻 == 메인스레드 스택에 run 스택 프레임이 IN
        helloThread.start();
        System.out.println(Thread.currentThread().getName() + ": start() 호출 후");

        System.out.println(Thread.currentThread().getName() + ": main() end");
    }
}
