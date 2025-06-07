package java2.network.tcp.mychatting;

import java.io.*;
import java.net.Socket;

import static java2.network.tcp.SocketCloseUtil.closeAll;
import static java2.util.MyLogger.log;

public class Session implements Runnable {
    private final Socket socket;
    private final DataInputStream input;
    private final DataOutputStream output;
    private final SessionManager sessionManager;

    private String name;
    private boolean closed = false;

    public Session(Socket socket, SessionManager sessionManager) throws IOException {
        this.socket = socket;
        this.input = new DataInputStream(socket.getInputStream());
        this.output = new DataOutputStream(socket.getOutputStream());
        this.name = this.input.readUTF();
        this.sessionManager = sessionManager;
        this.sessionManager.add(this);
    }

    @Override
    public void run() {
        try {
            while (true) {
                // 클라이언트로부터 문자 받기
                String received = input.readUTF();

                String[] message = received.split("\\|");
                String command = message[0];

                switch (command) {
                    case "/exit" -> {
                        return;
                    }
                    case "/users" -> {
                        output.writeUTF(sessionManager.getAllUserNames());
                    }
                    case "/message" -> {
                        sessionManager.sendAll((message[1]));
                    }
                    case "/change" -> {
                        String newName = message[1];
                        this.name = newName;
                    }
                }
            }
        } catch (IOException e) {
            log(e);
        } finally {
            sessionManager.remove(this); // 클라이언트가 종료할때 필수적으로 정리되어야함! 서버 종료시에는 굳이 필요없긴함
            close();
        }
    }

    public void send(String message) throws IOException {
        output.writeUTF(message);
    }

    public String getName() {
        return this.name;
    }

    public synchronized void close() {
        if (closed) {
            return;
        }
        closeAll(socket, input, output);
        closed = true;
        log("연결 종료: " + socket);
    }
}
