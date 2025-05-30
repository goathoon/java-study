package java2.io.start;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class StreamStartMain3 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("temp/hello.data");
        byte[] input = {65, 66, 67};
        fos.write(input);
        fos.close();

        FileInputStream fis = new FileInputStream("temp/hello.data");
        byte[] readBytes = fis.readAllBytes();
        System.out.println(Arrays.toString(readBytes));
        fis.close();
    }
}
