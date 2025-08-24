package java3.lambda.lambda3;

import java.util.function.Function;

// 자바가 기본으로 제공하는 Function 사용
public class TargetType2 {

    public static void main(String[] args) {
        Function<String, String> upperCase = s-> s.toUpperCase();
        System.out.println("upperCase.apply(\"hello\") = " + upperCase.apply("hello"));

        Function<Integer, Integer> square = n -> n * n;
        System.out.println("square.apply(4) = " + square.apply(4));
    }
}
