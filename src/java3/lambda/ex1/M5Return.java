package java3.lambda.ex1;

import java3.lambda.MyFunction;

public class M5Return {
    static MyFunction getOperation(String operator) {
        switch (operator) {
            case "add" :
                return (a, b) -> a + b;
            case "sub" :
                return (a, b) -> a - b;
            default :
                return (a,b) -> 0;
        }
    }

    public static void main(String[] args) {
        MyFunction add = getOperation("add");
        add.apply(1,2);
        MyFunction sub = getOperation("sub");
        sub.apply(1,2);
        MyFunction sxx = getOperation("sxx");
        sxx.apply(2,3);


    }
}
