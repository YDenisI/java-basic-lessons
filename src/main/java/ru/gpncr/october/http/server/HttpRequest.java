package ru.gpncr.october.http.server;

import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class HttpRequest {
    private String rawRequest;
    private HttpMethod method;
    private String uri;
    private Map<String, String> parameters;
    private Exception exception;
    private Socket socket;

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

    public HttpRequest(String rawRequest, Socket socket) {
        this.rawRequest = rawRequest;
        this.socket = socket;
        this.parse();
    }

    public Socket getSocket() {
        return socket;
    }

    public String getUri() {
        return uri;
    }

    public String getParameter(String key) {
        return parameters.get(key);
    }

    public boolean containsParameter(String key) {
        return parameters.containsKey(key);
    }

    private void parse() {
        int startIndex = rawRequest.indexOf(' ');
        int endIndex = rawRequest.indexOf(' ', startIndex + 1);
        uri = rawRequest.substring(startIndex + 1, endIndex);
        method = HttpMethod.valueOf(rawRequest.substring(0, startIndex));
        parameters = new HashMap<>();
        if (uri.contains("?")) {
            String[] elements = uri.split("[?]");
            uri = elements[0];
            String[] keysValue = elements[1].split("[&]");
            for (String o : keysValue) {
                String[] keyValue = o.split("=");
                parameters.put(keyValue[0], keyValue[1]);
            }
        }
    }

    public void info(boolean debug) {
        if (debug) {
            System.out.println(rawRequest);
        }

        System.out.println("Method: " + method);
        System.out.println("Uri: " + uri);
        System.out.println("Parameter: " + parameters);
    }
}
