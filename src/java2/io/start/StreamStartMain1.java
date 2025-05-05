package java2.io.start;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class StreamStartMain1 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("temp/hello.dat");
        fos.write(65);
        fos.write(66);
        fos.write(67);
        // 파일에 65, 66, 67을 나타내는 바이트가 ASCII를 통해 읽을 수 있는 언어로 디코딩된다.
        fos.close();

        FileInputStream fis = new FileInputStream("temp/hello.dat");
        int data;
        while ((data = fis.read()) != -1) {
            System.out.println(data);
        }

        fis.close();
    }
}
