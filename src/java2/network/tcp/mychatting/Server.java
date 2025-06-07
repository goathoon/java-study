package java2.network.tcp.mychatting;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static java2.util.MyLogger.log;

public class Server {

    private final static Integer PORT = 12345;

    public static void main(String[] args) throws IOException {
        log("서버 시작");
        ServerSocket serverSocket = new ServerSocket(PORT);
        SessionManager sessionManager = new SessionManager();
        log("서버 소켓 시작 - 리스닝 포트: " + PORT);

        try {
            while (true) {
                Socket socket = serverSocket.accept();
                log("소켓 연결: " + socket);

                Session session = new Session(socket, sessionManager);
                new Thread(session).start();
            }
        } catch (IOException e) {
            log ("서버 소켓 종료: " + e);
        }
    }
}
