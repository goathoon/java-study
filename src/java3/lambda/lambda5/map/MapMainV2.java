package java3.lambda.lambda5.map;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class MapMainV2 {

    public static void main(String[] args) {
        List<String> strings = List.of("1", "12", "123", "1234");

        // 문자열을 숫자로 변환
        List<Integer> numbers = mapper(strings, s -> Integer.parseInt(s));
        System.out.println("numbers = " + numbers);

        // 문자열의 길이를 반환
        List<Integer> lengths = mapper(strings, s -> s.length());
        System.out.println("lengths = " + lengths);
    }

    private static List<Integer> mapper(List<String> strings, Function<String, Integer> mapper) {
        List<Integer> list = new ArrayList<>();
        for(String str : strings) {
            list.add(mapper.apply(str));
        }
        return list;
    }
}
