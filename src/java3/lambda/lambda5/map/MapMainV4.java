package java3.lambda.lambda5.map;

import java.util.List;

public class MapMainV4 {

    public static void main(String[] args) {
        List<String> fruits = List.of("apple", "banana", "watermelon");

        // String -> String
        List<String> upperCases = GenericMapper.map(fruits, fruit -> fruit.toUpperCase());
        System.out.println("upperCases = " + upperCases);

        // String -> Integer
        List<Integer> lengthFruits = GenericMapper.map(fruits, fruit -> fruit.length());
        System.out.println("lengthFruits = " + lengthFruits);

        // Integer -> String
        List<Integer> integers = List.of(1, 2, 3);
        List<String> makeStars = GenericMapper.map(integers, "*"::repeat);
        System.out.println("makeStars = " + makeStars);

    }
}
