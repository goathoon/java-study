package java3.lambda.lambda4;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

public class BiMain {

    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> consumer1 = (a, b) -> a + b;
        System.out.println("consumer1.apply(1,2) = " + consumer1.apply(1, 2));

        BiConsumer<String, Integer> repeat = (s, n) -> {
            for(int i = 0; i < n; i++) {
                System.out.print(s);
            }
        };
        System.out.print("repeat.accept() = ");
        repeat.accept("*", 5);

        BiPredicate<Integer, Integer> isGreater = (a, b) -> a > b;
        System.out.println("isGreater.accept(2,1) = " + isGreater.test(2,1));



    }
}
