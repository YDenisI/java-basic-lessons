package ru.gpncr.java.basic.lessons;

import java.util.Arrays;

public class HomeWork {
    public static void main(String[] args) {
        int[][] arr = {{-1, -2, -3}, {4, 2, -3}, {5, -11, 22}, {0, -7, -4}};

        int total = sumOfPositiveElements(arr);

        if (total > 0)
            System.out.println("1. Сумма положительных элементов массива " + Arrays.deepToString(arr) + " равна " + total);
        else
            System.out.println("Массив не содержит положительных чисел");

        System.out.println("\n2. Так как в задании не было обозначено, как должен выглядеть квадрат, отрисуем двумя способами\n");

        drawSquare(7);

        System.out.println("\n3. Наглядно продемонстрировать диагональ лучше для квадратного массива:");

        int[][] arr2 = {{-5, 10, -3, 14}, {4, 2, -3, 12}, {5, -11, 2, 11}, {16, -7, -4, 21}};

        System.out.println(Arrays.deepToString(arr2));

        zeroDiagonalElements(arr2);

        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2[0].length; j++) {
                System.out.print(arr2[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println("\n4. Максимальное число массива " + Arrays.deepToString(arr) + " равно " + findMax(arr) + "\n");

        int result = sumElementsTwoLinesArray(arr);

        if (sumElementsTwoLinesArray(arr) < 0)
            System.out.println("\n5. Второй строки в массиве не существует, результат " + result + "\n");
        else
            System.out.println("\n5. Сумма элементов второй строки массива " + Arrays.deepToString(arr) + " равна " + result + "\n");
    }

    public static int sumOfPositiveElements(int[][] array) {

        int total = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] > 0) total += array[i][j];
            }
        }
        return total;
    }

    public static void drawSquare(int size) {

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        System.out.println();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == 0 || i == size - 1)
                    System.out.print("* ");
                else if (j != 0 && j != size - 1)
                    System.out.print("  ");
                if (i != 0 && i != size - 1 && (j == 0 || j == size - 1))
                    System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void zeroDiagonalElements(int[][] array) {

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (i == j) array[i][j] = 0;
            }
        }
    }

    public static int findMax(int[][] array) {

        int maxElement = array[0][0];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (maxElement <= array[i][j]) maxElement = array[i][j];
            }
        }
        return maxElement;
    }

    public static int sumElementsTwoLinesArray(int[][] array) {

        int total = 0;

        if (array.length < 2) return -1;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (i == 1) {
                    total += array[i][j];
                }
            }
        }
        return total;
    }

}
