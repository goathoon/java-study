package java2.network.tcp;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import static java2.util.MyLogger.log;

public class SocketCloseUtil {
    public static void closeAll(Socket socket, InputStream input, OutputStream output) {
        close(input);
        close(output);
        close(socket);
    }

    public static void close(InputStream input) {
        if (input != null) {
            try {
                input.close();
            } catch (Exception e) {
                log(e.getMessage());
            }
        }
    }

    public static void close(OutputStream output) {
        if (output != null) {
            try {
                output.close();
            } catch (Exception e) {
                log(e.getMessage());
            }
        }
    }

    public static void close(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (Exception e) {
                log(e.getMessage());
            }
        }
    }
}
