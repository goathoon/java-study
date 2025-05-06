package java2.io.start;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static java.nio.charset.StandardCharsets.UTF_8;

public class PrintStreamMain {
    public static void main(String[] args) throws IOException {
        // PrintStream 도 결국 OutputStream 상속받아 사용됨
        PrintStream printStream = System.out;

        byte[] bytes = "Hello!\n".getBytes(UTF_8);
        printStream.write(bytes); // -> 부모클래스가 제공하는 기능
        printStream.println("Print!"); // -> PrintStream 자체적으로 제공하는 기능

    }
}
