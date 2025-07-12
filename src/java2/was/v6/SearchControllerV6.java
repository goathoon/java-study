package java2.was.v6;

import java2.was.httpserver.HttpRequest;
import java2.was.httpserver.HttpResponse;

import java.io.IOException;

public class SearchControllerV6 {

    public void search(HttpRequest request, HttpResponse response) {
        String query = request.getParameter("q");
        response.writeBody("<h1>search</h1>");
        response.writeBody("<ul>");
        response.writeBody("<li>query: " + query +  "</li>");
        response.writeBody("</ul>");
    }
}
