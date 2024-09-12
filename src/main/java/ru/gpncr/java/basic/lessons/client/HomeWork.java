package ru.gpncr.java.basic.lessons.client;

import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class HomeWork {
    public static void main(String[] args) {

        try (Socket socket = new Socket("localhost", 8000);
             PingClient client = new PingClient(socket)
        ) {
            Scanner scanner = new Scanner(System.in);
            String userInput = null;
            String serverResponse = client.read();
            System.out.println(serverResponse);
            StringBuilder sb = new StringBuilder();
            while (true) {
                System.out.println("Для выхода 'exit' введите: ");
                System.out.println("Введите первое число: ");
                userInput = scanner.nextLine();

                if (Utils.checkExit(userInput)) {
                    break;
                }
                if (!Utils.isNumeric(userInput)) {
                    System.out.println("Введено не число или неверный формат числа");
                    break;
                }
                sb.append(userInput + " ");
                System.out.print("Введите второе число: ");
                userInput = scanner.nextLine();
                if (Utils.checkExit(userInput)) {
                    break;
                }
                if (!Utils.isNumeric(userInput)) {
                    System.out.println("Введено не число или неверный формат числа");
                    break;
                }
                sb.append(userInput);
                System.out.print("Введите операцию: ");
                userInput = scanner.nextLine();

                if (Utils.checkExit(userInput)) {
                    break;
                }
                if (!userInput.contains("+") && !userInput.contains("-") && !userInput.contains("/") && !userInput.contains("*")) {
                    System.out.print("Введена недопустимая операция: ");
                    break;
                }
                sb.insert(2, userInput + " ");
                client.send(sb.toString());
                System.out.println(client.read());
            }

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
