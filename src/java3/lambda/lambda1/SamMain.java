package java3.lambda.lambda1;

public class SamMain {
    public static void main(String[] args) {
        SamInterface samInterface = () -> {
            System.out.println("sam");
        };
        samInterface.run();

        // 컴파일 오류남
//        NotSamInterface notSamInterface = () -> {
//            System.out.println("sam");
//        };
//        notSamInterface.run();
//        notSamInterface.go();
    }
}
