package ru.gpncr.java.basic.lessons;

public class HomeWork {
    public static void main(String[] args) {
        System.out.println("HomeWork");

        printString(5, "HomeWork: Lesson 2");
    }

    public static void printString(int n, String s) {

        for (int i = 0; i < n; i++) {
            System.out.println(i + 1 + ". " + s);
        }
    }
}
