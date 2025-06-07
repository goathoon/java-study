package java2.network.tcp.mychatting;

import java2.network.tcp.SocketCloseUtil;

import java.io.DataInputStream;
import java.io.IOException;
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
            String received = null;
            try {
                received = input.readUTF();
            } catch (IOException e) {
                log(e);
                running = false;
                break;
            }
            System.out.println(received);
        }
    }

    public void stop() {
        running = false;
        SocketCloseUtil.close(input);
        SocketCloseUtil.close(socket);
    }
}
