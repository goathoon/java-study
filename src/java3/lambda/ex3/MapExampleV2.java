package java3.lambda.ex3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

public class MapExampleV2 {

    public static List<String> map(List<String> list, UnaryOperator<String> func) {
        List<String> result = new ArrayList<>();
        for (String str : list) {
            result.add(func.apply(str));
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> words = List.of("hello", "java", "lambda");
        System.out.println("원본 리스트: " + words);

        // 1. 대문자 변환
        // 코드 작성
        List<String> upperWords = map(words, word -> word.toUpperCase());
        System.out.println(upperWords);

        // 2. 앞뒤에 *** 붙이 (람다로 작성)
        // 코드 작성
        List<String> starWords = map(words, word -> "***" + word + "***");
        System.out.println(starWords);
    }
}
