package java3.lambda.lambda4;

import java.util.function.IntFunction;
import java.util.function.IntToLongFunction;
import java.util.function.IntUnaryOperator;
import java.util.function.ToIntFunction;

public class PrimitiveFunction {
    public static void main(String[] args) {
        // 기본형 매개변수, IntFunction, LongFunction, DoubleFunction
        IntFunction<String> intFunction = a -> "숫자: " + a;
        System.out.println("intFunction = " + intFunction.apply(1));

        // 기본형 반환, ToIntFunction, ToLongFunction, ToDoubleFunction
        ToIntFunction<String> toIntFunction = s -> s.length();
        System.out.println("toIntFunction.applyAsInt(\"hello\") = " + toIntFunction.applyAsInt("hello"));

        // 기본형 매개변수, 기본형 반환
        IntToLongFunction intToLongFunction = x -> x * 100L;
        System.out.println("intToLongFunction.applyAsLong(1) = " + intToLongFunction.applyAsLong(1));

        // IntUnaryOperator : int -> int
        IntUnaryOperator intUnaryOperator = x -> x * 2;
        System.out.println("intUnaryOperator.applyAsInt(2) = " + intUnaryOperator.applyAsInt(2));

        // 기타, IntConsumer, IntSupplier, IntPredicate
    }
}
