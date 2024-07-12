package ru.gpncr.java.basic.lessons;

import java.lang.reflect.Array;
import java.util.Arrays;

public class HomeWork {
    public static void main(String[] args) {
        System.out.println("HomeWork");
        System.out.println("1. Реализуйте метод, принимающий в качестве аргументов целое число и строку, и печатающий в консоль строку указанное количество раз.");
        printString(5, "HomeWork: Lesson 2");

        System.out.println("\n2. Реализуйте метод, принимающий в качестве аргумента целочисленный массив, суммирующий все элементы, значение которых больше 5, и печатающий полученную сумму в консоль.");
        int[] array_1  = new int[] {7, -2, 14, 1};
        System.out.println("Входные данные:"+Arrays.toString(array_1));
        System.out.println("Результат:");
        sumElementsArray(array_1);

        System.out.println("\n3. Реализуйте метод, принимающий в качестве аргументов целое число и ссылку на целочисленный массив, метод должен заполниться каждую ячейку массива указанным числом.");
        int[] array_2  = new int[10];
        int param_2 = 6;
        System.out.println("Входные данные:("+param_2+","+Arrays.toString(array_2)+")");
        addValueArray(param_2,array_2);
        System.out.println("Результат после выполнения метода:");
        System.out.print("[");
        for (int i = 0; i < array_2.length; i++) {
             if (i < array_2.length-1)
                System.out.print(array_2[i] + ",");
            else
                System.out.print(array_2[i]);
        }
        System.out.println("]");

        System.out.println("\n4. Реализуйте метод, принимающий в качестве аргументов целое число и ссылку на целочисленный массив, увеличивающий каждый элемент которого на указанное число.");
        int[] array_3  = new int[] {7, -2, 14, 1};
        int param_3 = 6;
        System.out.println("Входные данные:("+param_3+","+Arrays.toString(array_3)+")");
        changeValueArray(param_3,array_3);
        System.out.println("Результат после выполнения метода:");
        System.out.print("[");
        for (int i = 0; i < array_3.length; i++) {
            if (i < array_3.length-1)
                System.out.print(array_3[i] + ",");
            else
                System.out.print(array_3[i]);
        }
        System.out.println("]");

        System.out.println("\n5. -Реализуйте метод, принимающий в качестве аргумента целочисленный массив, и печатающий в консоль сумма элементов какой из половин массива больше.");
        int[] array_4  = new int[] {7, -1, 14, 1};
        System.out.println("Входные данные:"+Arrays.toString(array_4));
        sumPartsArray(array_4);
    }

    public static void printString(int n, String s) {
        System.out.println("Входные параметры: ("+n+",\""+s+"\")");
        System.out.println("Результат:");
        if (n <= 0) System.out.println("Значение первого параметра  <= 0. Выход");
        for (int i = 0; i < n; i++) {
            System.out.println(i + 1 + ". " + s);
        }
    }

    public static void sumElementsArray(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
              if (array[i] > 5) sum+=array[i];
        }
        System.out.println("Сумма элементов массива: "+sum);
    }

    public static void addValueArray(int n, int[] array) {
        if (n <= 0){
            System.out.println("Значение первого параметра  <= 0. Выход");
            return ;
        };
//        System.out.println("\nРезультат:");
//        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            array[i] = n;
  /*          if (i < array.length-1)
                System.out.print(array[i] + ",");
            else
                System.out.print(array[i]);*/
        }
      //  System.out.print("]");
    }

    public static void changeValueArray(int n, int[] array) {
        if (n <= 0){
            System.out.println("Значение первого параметра  <= 0. Выход");
            return ;
        };
//        System.out.println("\nРезультат:");
//        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            array[i] += n;
  /*          if (i < array.length-1)
                System.out.print(array[i] + ",");
            else
                System.out.print(array[i]);*/
        }
        //  System.out.print("]");
    }

    public static void sumPartsArray(int[] array) {
        int sumFirstPart = 0;
        int sumSecondPart = 0;
        if (array.length % 2 != 0){
            System.out.println("Размер массива нечетный. Выход");
            return;
        }
        for (int i = 0; i < array.length; i++) {
            if (i <= array.length/2-1) sumFirstPart += array[i];
            else sumSecondPart+= array[i];
        }
       // System.out.println("Сумма чисел первой половины массива = "+sumFirstPart);
       // System.out.println("Сумма чисел второй половины массива = "+sumSecondPart);
        if (sumFirstPart == sumSecondPart) System.out.println("Суммы элементов первой и второй половин массива равны");
        else if (sumFirstPart > sumSecondPart) System.out.println("Сумма элементов первой половины массива больше");
        else System.out.println("Сумма элементов второй половины массива больше");
    }
}
