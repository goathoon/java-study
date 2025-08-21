package java3.lambda.ex1;

import java3.lambda.Procedure;

import java.util.Arrays;

public class M3MyMeasureTime {

    public static void main(String[] args) {
         Procedure sum = new Procedure () {
             @Override
             public void run() {
                 int ans = 0;
                 for(int i = 1; i <= 100; i++) {
                    ans += i;
                 }
                 System.out.println("[1부터 100까지의 합] 결과: " + ans);
             }
         };

         Procedure sort = new Procedure() {
             @Override
             public void run() {
                 int[] arr = {4, 3, 2, 1};
                 System.out.println("원본 배열: " + Arrays.toString(arr));
                 Arrays.sort(arr);
                 System.out.println("배열 정렬: " + Arrays.toString(arr));
             }
         };

         measure(sum);
         measure(sort);
    }

    public static void measure(Procedure procedure) {
        long startNs = System.nanoTime();
        procedure.run();
        long endNs = System.nanoTime() ;
        System.out.println("실행시간: " + (endNs - startNs) + "ns");

    }
}
