package ru.gpncr.october.http.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpServer {

    private static final int POOL_SIZE = 10;

    private int port;
    private Dispatcher dispatcher;
    ExecutorService threadPool;

    public HttpServer(int port) {
        this.port = port;
        this.threadPool = Executors.newFixedThreadPool(POOL_SIZE);
        this.dispatcher = new Dispatcher();
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server run port " + port);
            while (true) {
                // try (Socket socket = serverSocket.accept()) {
                Socket socket = serverSocket.accept();
                byte[] buffer = new byte[8192];
                int n = socket.getInputStream().read(buffer);
                String rawRequest = new String(buffer, 0, n);
                System.out.println(rawRequest);
                threadPool.submit(() -> {
                    try {
                        HttpRequest request = new HttpRequest(rawRequest, socket);
                        request.info(true);
                        dispatcher.execute(request, socket.getOutputStream());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
