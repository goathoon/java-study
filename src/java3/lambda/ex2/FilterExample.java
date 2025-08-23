package java3.lambda.ex2;

import java.util.ArrayList;
import java.util.List;

public class FilterExample {

    public static List<Integer> filter(List<Integer> list, MyPredicate predicate) {
        List<Integer> result = new ArrayList<>();
        for (int val : list) {
            if (predicate.test(val)) {
                result.add(val);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, -2, 3, 0, 5, -10, 7);
        System.out.println("원본 리스트: " + numbers);

        // 1. 음수(negative)만 뽑아내기
        // 코드 작성
        List<Integer> negativeNumbers = filter(numbers, num -> num < 0);
        System.out.println(negativeNumbers);


        // 2. 짝수(even)만 뽑아내기
        // 코드 작성
        List<Integer> evenNumbers = filter(numbers, num -> num % 2 == 0);
        System.out.println(evenNumbers);
    }
}
