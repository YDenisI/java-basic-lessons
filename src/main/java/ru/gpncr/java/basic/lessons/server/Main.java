package ru.gpncr.java.basic.lessons.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8000)) {
            System.out.println("Сервер запущен. Ожидание подключения клиента...");
            Socket clientSocket = serverSocket.accept();
            while (true) {
                System.out.println("Клиент подключён: " + clientSocket.getInetAddress());
                if (!clientSocket.isClosed()) readRequest(clientSocket);
                else {
                    System.out.println("Клиент завершил работу");
                    break;

                }
            }
        } catch (IOException e) {
            System.err.println("Ошибка сервера: " + e.getMessage());
        }
    }

    private static void readRequest(Socket clientSocket) {
        try (DataOutputStream out = new DataOutputStream(new BufferedOutputStream(clientSocket.getOutputStream()));
             DataInputStream in = new DataInputStream(new BufferedInputStream(clientSocket.getInputStream()))) {

            out.writeUTF("Доступные операции: +, -, *, /");
            out.flush();
            String request = in.readUTF();
            List<String> parts = Arrays.asList(request.split(" "));
            double number1 = Double.parseDouble(parts.get(0));
            String operation = parts.get(1);
            double number2 = Double.parseDouble(parts.get(2));

            double result = getResult(number1, operation, number2);
            out.writeUTF("Результат: " + result);
            out.flush();
        } catch (IOException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    private static double getResult(double num1, String operation, double num2) {
        switch (operation) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (num2 == 0) throw new ArithmeticException("Деление на ноль невозможно.");
                return num1 / num2;
            default:
                throw new IllegalArgumentException("Неизвестная операция: " + operation);
        }
    }
}
