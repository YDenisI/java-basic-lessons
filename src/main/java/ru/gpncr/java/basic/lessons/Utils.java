package ru.gpncr.java.basic.lessons;

import java.util.List;

public class Utils {

    public static final boolean checkNullAndEmptyList(List ls) {
        if (ls == null) return true;
        if (ls.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
