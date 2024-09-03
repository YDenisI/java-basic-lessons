package ru.gpncr.java.basic.lessons;

import java.io.*;
import java.util.Scanner;

public class HomeWork {
    public static void main(String[] args) {

        try {
            File directory = new File("./");
            String[] files = directory.list();

            File[] f = directory.listFiles();
            if (f != null) {
                System.out.println("Доступные текстовые файлы:");
                for (File file : f) {
                    if (file.isFile() && file.getName().toLowerCase().endsWith(".txt")) {
                        System.out.println(file.getName());
                    }
                }
            }
            if (files != null) {
                System.out.println("Доступные текстовые файлы:");
                for (int i = 0; i < files.length; i++) {
                    if (files[i].toLowerCase().endsWith(".txt")) {
                        System.out.println(files[i]);
                    }
                }
            } else {
                System.out.println("Нет доступных файлов.");
            }

            System.out.print("Введите имя файла (с расширением .txt): ");
            Scanner in = new Scanner(System.in);
            String fileName = in.nextLine();

            File inputFile = new File(fileName);
            if (inputFile.exists() && inputFile.isFile()) {
                System.out.println("Содержимое файла " + fileName + ":");
                getContent(inputFile);
            } else {
                System.out.println("Файл не найден. Пожалуйста, проверьте имя.");
                return;
            }

            System.out.println("\n\nВведите строки для записи в файл (для выхода введите 'exit'):");
            String line;
            while (true) {
                line = in.nextLine();
                if (line.equalsIgnoreCase("exit")) {
                    break;
                }
                appendToFile(inputFile, line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getContent(File file) throws IOException {
        try (InputStreamReader in = new InputStreamReader(new FileInputStream(file.getName()))) {
            int n = in.read();
            while (n != -1) {
                System.out.print((char) n);
                n = in.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void appendToFile(File file, String line) {
        BufferedOutputStream bufferedOutputStream = null;
        try {
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file, true));
            bufferedOutputStream.write((" " + line).getBytes());
        } catch (IOException e) {
            System.err.println("Ошибка записи в файл: " + e.getMessage());
        } finally {
            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    System.err.println("Ошибка при закрытии файла: " + e.getMessage());
                }
            }
        }
    }
}
