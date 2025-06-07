package java2.network.tcp.chatting;

import java2.network.tcp.SocketCloseUtil;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.UUID;

import static java2.network.tcp.SocketCloseUtil.closeAll;
import static java2.util.MyLogger.log;

public class Client {

    private static final int PORT = 12345;

    public static void main(String[] args) throws InterruptedException, IOException {
        Scanner scanner = new Scanner(System.in);

        log("클라이언트 시작");
        System.out.println("입장 명령어를 입력하세요! /join|{name}");
        String name = null;
        while(true) {
            try {
                System.out.print("입력: ");
                String joinMessage = scanner.nextLine();
                name = CommandUtils.parseJoinName(joinMessage);
            } catch (RuntimeException e) {
                log(e);
                continue;
            }
            break;
        }

        if(name.isBlank()) {
            throw new RuntimeException("잘못된 입력! 다시 연결하세요");
        }

        Socket socket = null;
        DataInputStream input = null;
        DataOutputStream output = null;
        ClientReadSession clientReadSession = null;

        try {
            socket = new Socket("localhost", PORT);
            input = new DataInputStream(socket.getInputStream());
            output = new DataOutputStream(socket.getOutputStream());
            clientReadSession = new ClientReadSession(socket, input);

            new Thread(clientReadSession).start();

            // Client를 구별하기 위한 UUID값 전송
            output.writeUTF(name);

            log("채팅 시작! 이름 : [ " + name + " ]");

            while (true) {
//                System.out.print("채팅을 입력하세요: ");
                String toSend;
                try {
                    toSend = scanner.nextLine();
                    CommandUtils.validateAfterMessage(toSend);
                } catch (RuntimeException e) {
                    log(e);
                    continue;
                }
                // 서버에게 문자 보내기
                output.writeUTF(toSend + "|" + name);
                Thread.sleep(100);

                if (toSend.equals("/exit")) {
                    break;
                }
            }
        } finally {
            clientReadSession.stop();
            closeAll(socket, input, output);
        }

    }
}
