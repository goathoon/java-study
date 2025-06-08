package java2.chat.server.command;

import java2.chat.server.Session;
import java2.chat.server.SessionManager;

import java.io.IOException;

public class ExitCommand implements Command {

    @Override
    public void execute(String[] args, Session session) throws IOException {
        throw new IOException("exit");
    }
}
