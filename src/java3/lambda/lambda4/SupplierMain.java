package java3.lambda.lambda4;

import java.util.function.Supplier;

public class SupplierMain {
    public static void main(String[] args) {
        Supplier<String> supplier1 = new Supplier<String>() {
            @Override
            public String get() {
                return "hello";
            }
        };
        System.out.println(supplier1.get());

        Supplier<String> supplier2 = () -> "hello";
        System.out.println(supplier2.get());
    }
}
