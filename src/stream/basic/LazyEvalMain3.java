package stream.basic;

import java3.lambda.lambda5.mystream.MyStreamV3;

import java.util.List;
import java.util.Optional;

public class LazyEvalMain3 {
    public static void main(String[] args) {
        List<Integer> data = List.of(1, 2, 3, 4);
        ex1(data);
        ex2(data);

    }

    private static void ex1(List<Integer> data) {
        System.out.println("== MyStreamV3 시작 ==");
        int result = MyStreamV3.of(data)
                .filter(i -> {
                    boolean isEven = (i % 2 == 0);
                    System.out.println("filter() 실행: " + i + "(" + isEven + ")");
                    return isEven;
                })
                .map(i -> {
                    int mapped = i * 10;
                    System.out.println("map() 실행: " + i + "->" + mapped);
                    return mapped;
                })
                .getFirst();
        System.out.println("result = " + result);
        System.out.println("== MyStreamV3 종료 ==");
    }

    private static void ex2(List<Integer> data) {
        System.out.println("== 스트림 API 시작 ==");
        int result = data.stream()
                .filter(i -> {
                    boolean isEven = (i % 2 == 0);
                    System.out.println("filter() 실행: " + i + "(" + isEven + ")");
                    return isEven;
                })
                .map(i -> {
                    int mapped = i * 10;
                    System.out.println("map() 실행: " + i + "->" + mapped);
                    return mapped;
                })
                .findFirst().get();
        System.out.println("result = " + result);
        System.out.println("== 스트림 API 종료 ==");
    }
}
