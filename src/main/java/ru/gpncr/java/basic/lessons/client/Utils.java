package ru.gpncr.java.basic.lessons.client;

public class Utils {

    public static boolean checkExit(String string) {
        return string.equalsIgnoreCase("exit");
    }

    public static boolean isNumeric(String string) {
        return string.matches("-?\\d+(\\.\\d+)?");
    }
}
