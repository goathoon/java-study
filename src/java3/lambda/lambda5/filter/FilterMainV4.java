package java3.lambda.lambda5.filter;

import java.util.List;

import static java3.lambda.lambda5.filter.GenericFilter.filter;

public class FilterMainV4 {
    public static void main(String[] args) {
        // 숫자 사용 필터
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> numberResult = filter(numbers, n -> n % 2 == 0);
        System.out.println("evenNumbers = " + numberResult);

        // 문자 사용 필터
        List<String> strings = List.of("A", "BB", "CCC", "DDDD", "E", "FFFFFFFF");
        List<String> stringResult = filter(strings, s -> s.length() >= 2);
        System.out.println("stringResult = " + stringResult);
    }
}
