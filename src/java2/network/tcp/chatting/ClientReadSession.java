package java2.network.tcp.chatting;

import java2.network.tcp.SocketCloseUtil;

import java.io.DataInputStream;
import java.net.Socket;

import static java2.util.MyLogger.log;

public class ClientReadSession implements Runnable {

    private final Socket socket;
    private final DataInputStream input;
    private boolean running = true;

    public ClientReadSession(Socket socket, DataInputStream input) {
        this.socket = socket;
        this.input = input;
    }

    @Override
    public void run() {
        while (running) {
            try {
                String received = input.readUTF();
                System.out.println(received);
            } catch (Exception e) {
                log(e);
            }
        }
    }

    public void stop() {
        running = false;
        SocketCloseUtil.close(input);
        SocketCloseUtil.close(socket);
    }
}
