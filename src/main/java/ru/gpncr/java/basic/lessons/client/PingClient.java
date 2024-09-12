package ru.gpncr.java.basic.lessons.client;

import java.io.*;
import java.net.Socket;

public class PingClient implements AutoCloseable {
    private final DataInputStream inputStream;
    private final DataOutputStream outputStream;

    public PingClient(Socket socketm) throws IOException {
        this.inputStream = new DataInputStream(new BufferedInputStream(socketm.getInputStream()));
        this.outputStream = new DataOutputStream(new BufferedOutputStream(socketm.getOutputStream()));
    }

    public void send(String message) throws IOException {
        outputStream.writeUTF(message);
        outputStream.flush();
    }

    public String read() throws IOException {
        return inputStream.readUTF();
    }

    @Override
    public void close() throws Exception {
        inputStream.close();
        outputStream.close();
    }
}
