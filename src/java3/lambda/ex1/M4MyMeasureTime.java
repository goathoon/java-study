package java3.lambda.ex1;

import java3.lambda.Procedure;

import java.util.Arrays;

public class M4MyMeasureTime {

    public static void main(String[] args) {
         measure(() -> {
             int ans = 0;
             for(int i = 1; i <= 100; i++) {
                 ans += i;
             }
             System.out.println("[1부터 100까지의 합] 결과: " + ans);
         });
         measure(() -> {
             int ans = 0;
             for(int i = 1; i <= 100; i++) {
                 ans += i;
             }
             System.out.println("[1부터 100까지의 합] 결과: " + ans);
         });
    }

    public static void measure(Procedure procedure) {
        long startNs = System.nanoTime();
        procedure.run();
        long endNs = System.nanoTime() ;
        System.out.println("실행시간: " + (endNs - startNs) + "ns");

    }
}
