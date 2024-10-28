package ru.gpncr.java.basic.lessons;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeWork {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(elementsAfterLastOne(new int[]{1, 2, 1, 2, 2})));
    }

    public static int[] elementsAfterLastOne(int[] array) {
        int index = -1;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                index = i;
            }
        }

        if (index == -1) {
            throw new RuntimeException("Массив не содержит единиц.");
        }

        List<Integer> result = new ArrayList<>();
        for (int i = index + 1; i < array.length; i++) {
            result.add(array[i]);
        }

        return result.stream().mapToInt(i -> i).toArray();
    }

    public static boolean validateArray(int[] array) {
        boolean containsOne = false;
        boolean containsTwo = false;

        for (int num : array) {
            if (num == 1) {
                containsOne = true;
            } else if (num == 2) {
                containsTwo = true;
            } else {
                return false;
            }
        }

        return containsOne && containsTwo;
    }
}
