package java3.lambda.lambda5.map;

import java.util.ArrayList;
import java.util.List;

public class MapMainV1 {

    public static void main(String[] args) {
        List<String> strings = List.of("1", "12", "123", "1234");

        // 문자열을 숫자로 변환
        List<Integer> numbers = mapStringToInteger(strings);
        System.out.println("numbers = " + numbers);

        // 문자열의 길이를 반환
        List<Integer> lengths = mapStringToLength(strings);
        System.out.println("lengths = " + lengths);
    }

    private static List<Integer> mapStringToLength(List<String> strings) {
        List<Integer> list = new ArrayList<>();
        for (String string : strings) {
            list.add(string.length());
        }
        return list;
    }

    private static List<Integer> mapStringToInteger(List<String> strings) {
        List<Integer> list = new ArrayList<>();
        for (String string : strings) {
            list.add(Integer.parseInt(string));
        }
        return list;
    }
}
