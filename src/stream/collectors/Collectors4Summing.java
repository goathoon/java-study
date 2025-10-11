package stream.collectors;

import java.util.IntSummaryStatistics;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Collectors4Summing {
    public static void main(String[] args) {
        // 다운 스트림 컬렉터에서 사용
        Long count1 = Stream.of(1,2,3)
                .collect(Collectors.counting());
        System.out.println("count1 = " + count1);

        Long count2 = Stream.of(1,2,3)
                .count();
        System.out.println("count2 = " + count2);

        Double avg = Stream.of(1, 2, 3)
                .collect(Collectors.averagingInt(x -> x));
        System.out.println("avg = " + avg);

        double avg2 = Stream.of(1, 2, 3)
                .mapToInt(i -> i)
                .average().getAsDouble();
        System.out.println("avg2 = " + avg2);

        // 기본형 특화 스트림 사용
        double avg3 = IntStream.of(1, 2, 3)
                .average().getAsDouble();
        System.out.println("avg3 = " + avg3);

        // 통계
        IntSummaryStatistics stats = Stream.of("Apple", "Banana", "Tomato")
                .collect(Collectors.summarizingInt(String::length));
        System.out.println(stats.getCount());
        System.out.println(stats.getSum());
        System.out.println(stats.getMin());
        System.out.println(stats.getMax());
        System.out.println(stats.getAverage());
    }
}
