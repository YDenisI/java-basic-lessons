package ru.gpncr.java.basic.lessons;

import java.io.*;
import java.nio.charset.StandardCharsets;
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

            System.out.println("\n\nВведите строку для поиска в файле:");

            String searchString = in.nextLine();
            System.out.println("Количество вхождени искомой строки " + searchString + " - " + countOccurrences(fileName, searchString));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getContent(File file) throws IOException {
        try (InputStreamReader in = new InputStreamReader(new FileInputStream(file.getName()), StandardCharsets.UTF_8)) {
            int n = in.read();
            while (n != -1) {
                System.out.print((char) n);
                n = in.read();
            }
        }
    }

    public static int countOccurrences(String fileName, String searchString) throws FileNotFoundException, IOException {

        int count = 0;
        try (InputStreamReader streamReader = new InputStreamReader(new FileInputStream(fileName), StandardCharsets.UTF_8)) {
            BufferedReader br = new BufferedReader(streamReader);
            String line;
            while ((line = br.readLine()) != null) {
                count += countOccurrencesInLine(line, searchString);

            }
        }
        return count;
    }

    public static int countOccurrencesInLine(String line, String searchString) throws IOException {

        int count = 0;
        int index = 0;
        while ((index = line.indexOf(searchString, index)) != -1) {
            count++;
            index += searchString.length();
        }
        return count;
    }

}