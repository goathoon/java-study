package java3.lambda.lambda5.mystream;

import java.util.List;

public class MyStreamMainV2 {

    public static void main(String[] args) {
        // 짝수만 남기고, 남은 값의 2배를 반환
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9,10);

        MyStreamV2.of(numbers)
                .filter(number -> number % 2 == 0)
                .map(number -> number * 2)
                .toList()
                .forEach(System.out::println);
    }

}
