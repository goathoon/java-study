package java3.lambda.lambda4;

import java.util.function.Predicate;

public class PredicateMain {
    public static void main(String[] args) {
        Predicate<Integer> predicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer i) {
                return i % 2 == 0;
            }
        };
        System.out.println("predicate.test(\"3\") = " + predicate.test(3));
        System.out.println("predicate.test(\"4\") = " + predicate.test(4));

        Predicate<Integer> predicate2 = x -> x % 2 == 0;
    }
}
