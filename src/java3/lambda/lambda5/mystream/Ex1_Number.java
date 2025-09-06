package java3.lambda.lambda5.mystream;

import java3.lambda.lambda5.filter.GenericFilter;
import java3.lambda.lambda5.map.GenericMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Ex1_Number {

    public static void main(String[] args) {
        // 짝수만 남기고, 남은 값의 2배를 반환
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> directResult = direct(numbers);
        System.out.println("directResult = " + directResult);

        List<Integer> lmabdaResult = lambda(numbers);
        System.out.println("lmabdaResult = " + lmabdaResult);
        
    }

    private static List<Integer> lambda(List<Integer> numbers) {
        List<Integer> list = new ArrayList<>();
        return GenericMapper.map(
                GenericFilter.filter(
                        numbers, n -> n % 2 == 0), n -> n * 2
        );
    }

    private static List<Integer> direct(List<Integer> numbers) {
        List<Integer> list = new ArrayList<>();

        for(int x : numbers) {
            if(x % 2 == 0) {
                list.add(x * 2);
            }
        }

        return list;
    }
}
