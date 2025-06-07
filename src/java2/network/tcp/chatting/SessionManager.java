package java2.network.tcp.chatting;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SessionManager {
    private List<Session> sessions = new ArrayList<>();

    public synchronized void add(Session session) {
        sessions.add(session);
    }

    public synchronized void remove(Session session) {
        sessions.remove(session);
    }

    public synchronized void sendAll(String message) throws IOException {
        for (Session session : sessions) {
            session.send(message);
        }
    }

    public synchronized String getAllUserNames() throws IOException {
        StringBuilder sb = new StringBuilder();
        int num = 1;
        for (Session session : sessions) {
            sb.append(num + " : ");
            sb.append(session.getName());
            sb.append("\n");
            num++;
        }
        return sb.toString();
    }

    public synchronized void closeAll() {
        for (Session session : sessions) {
            session.close();
        }
        sessions.clear();
    }
}
