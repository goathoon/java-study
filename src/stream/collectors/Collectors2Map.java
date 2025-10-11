package stream.collectors;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Collectors2Map {
    public static void main(String[] args) {
        Map<String, Integer> map1 = Stream.of("Apple", "Banana", "Orange")
                .collect(Collectors.toMap(
                        name -> name, // KeyMapper
                        name -> name.length() // valueMapper
                ));
        System.out.println("map1 = " +  map1);

        // 키 중복 예외
//        Map<String, Integer> map2 = Stream.of("Apple", "Apple", "Orange")
//                .collect(Collectors.toMap(
//                        name -> name, // KeyMapper
//                        name -> name.length() // valueMapper
//                ));
//        System.out.println("map2 = " +  map1);

        // 키 중복 대안 (병합)
        Map<String, Integer> map3 = Stream.of("Apple", "Apple", "Orange")
                .collect(Collectors.toMap(
                        name -> name, // KeyMapper
                        name -> name.length(), // valueMapper
                        (oldValue, newValue) -> oldValue + newValue // 중복될 경우 기존값 + 새 값
                ));
        System.out.println("map3 = " +  map3);

        // Map의 타입 지정
        Map<String, Integer> map4 = Stream.of("Apple", "Apple", "Orange")
                .collect(Collectors.toMap(
                        name -> name, // KeyMapper
                        name -> name.length(), // valueMapper
                        (oldValue, newValue) -> oldValue + newValue, // 중복될 경우 기존값 + 새 값
                        LinkedHashMap::new
                ));
        System.out.println("map4 = " +  map4.getClass());

    }
}
