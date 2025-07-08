package java2.was.httpserver.servlet;

import java2.was.httpserver.HttpRequest;
import java2.was.httpserver.HttpResponse;
import java2.was.httpserver.HttpServlet;

import java.io.IOException;

public class DiscardServlet implements HttpServlet {

    @Override
    public void service(HttpRequest request, HttpResponse response) throws IOException {
        //empty
    }
}
