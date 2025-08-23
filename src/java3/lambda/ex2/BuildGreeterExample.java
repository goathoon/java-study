package java3.lambda.ex2;

import java.io.IOException;

public class BuildGreeterExample {

    // 고차 함수, greeting 문자열을 받아, "새로운 함수"를 반환
    public static StringFunction buildGreeter(String greeting) throws IOException {
        return string -> greeting + ", "  + string;
    }

    public static void main(String[] args) throws IOException {
        StringFunction sf = buildGreeter("taehoon!");
        System.out.println(sf.apply("hello"));

        StringFunction helloGreeter = buildGreeter("Hello");
        StringFunction hiGreeter = buildGreeter("Hi");

        // 함수가 반환되었으므로, apply()를 호출해 실제로 사용
        helloGreeter.apply("Java"); // Hello, Java
        helloGreeter.apply("Lambda"); // Hi, Lambda
    }
}
