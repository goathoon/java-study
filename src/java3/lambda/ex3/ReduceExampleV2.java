package java3.lambda.ex3;

import java.util.List;
import java.util.function.BinaryOperator;

public class ReduceExampleV2 {

    // 함수를 인자로 받아, 리스트 요소를 하나로 축약(reduce)하는 고차 함
    public static int reduce(List<Integer> list, int initial, BinaryOperator<Integer> reducer){
        for (int x : list) {
            initial = reducer.apply(initial, x);
        }
        return initial;
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4);
        System.out.println("리스트: " + numbers);

        // 1. 합 구하기 (초기값 0, 덧셈로직)
        // 코드 작성
        int sum = reduce(numbers, 0, (a, b) -> a + b);
        System.out.println("합 : " + sum);

        // 2. 곱 구하기 (초기값 1, 곱셈로직)
        // 코드 작성
        int multiply = reduce(numbers, 1, (a, b) -> a * b);
        System.out.println("곱 : " + multiply);

    }
}
