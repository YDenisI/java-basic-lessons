package ru.gpncr.java.basic.lessons;

public class HomeWork {
    public static void main(String[] args) {
        String[][] arrayNumber = {
                {"1", "22", "3", "14"},
                {"-5", "6", "-7", "8"},
                {"9", "-10", "11", "12"},
                {"0", "-2", "15", "-16"}
        };

        String[][] arrayRectangular = {
                {"0", "1", "-3"},
                {"-8", "16", "7", "13"},
                {"-3", "-10", "-11", "22"}
        };

        String[][] array = {
                {"-1", "22", "3,14", "4"},
                {"25", "-6", "Text", "8.9"},
                {"-9", "0", "11", "-12"},
                {"13", "11", "5", "6"}
        };

        try {

            //   System.out.println("Сумма элементов числового массива: " + sumArray(arrayNumber));

            //  System.out.println("Сумма элементов прямоугольного массива: " + sumArray(arrayRectangular));

            System.out.println("Сумма элементов массива, содержащего не числовые значения: " + sumArray(array));
        } catch (AppArraySizeException | AppArrayDataException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static int sumArray(String[][] array) throws AppArraySizeException, AppArrayDataException {
        // Проверка на размер массива 4x4
        if (array.length != 4) {
            throw new AppArraySizeException("Размер массива неправильный. Ожидался массив 4x4.");
        }
        for (String[] row : array) {
            if (row.length != 4) {
                throw new AppArraySizeException("Размер массива неправильный. Ожидался массив 4x4.");
            }
        }

        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new AppArrayDataException("\nОшибка! В ячейке [" + i + "][" + j + "] значение '" + array[i][j] + "' не является целым числом.");
                }
            }
        }
        return sum;
    }
}
