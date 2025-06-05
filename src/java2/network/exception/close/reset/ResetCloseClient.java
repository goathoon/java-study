package java2.network.exception.close.reset;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;

import static java2.util.MyLogger.log;

public class ResetCloseClient {
    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket = new Socket("localhost", 12345);
        log("소켓 연결: " + socket);
        InputStream input = socket.getInputStream();
        OutputStream output = socket.getOutputStream();



        // Client <- Server: FIN
        Thread.sleep(1000); // 서버가 Close 호출할때 까지 대기

        // Client -> Server: PUSH[1] 서버 소켓이 닫혀있는데도 보낸다
        output.write(1);

        // Client <- Server: RST
        Thread.sleep(1000); // RST 메세지 전송 대기
        try {
            // java.net.SocketException: Connection reset -> 더이상 해당 커넥션을 쓰지 못함
            int read = input.read();
            System.out.println("read = " + read);
        } catch (SocketException e) {
            e.printStackTrace();
        }

        // 그럼에도 한번 더 보낸다면?
        try {
            output.write(1); // java.net.SocketException: Broken pipe 발생
        } catch (SocketException e) {
            e.printStackTrace();
        }

    }
}
