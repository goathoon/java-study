package java3.lambda.lambda5.mystream;

import java.util.List;

public class MyStreamMainV1 {

    public static void main(String[] args) {
        // 짝수만 남기고, 남은 값의 2배를 반환
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9,10);
        returnValue(numbers);

    }

    private static void returnValue(List<Integer> numbers) {
        MyStreamV1 stream = new MyStreamV1(numbers);
        System.out.println(
                stream.filter(i -> i % 2 == 0)
                        .map(i -> i * 2)
                        .toList()
        );
    }
}
