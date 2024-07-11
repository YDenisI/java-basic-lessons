package ru.gpncr.java.basic.lessons;

import java.util.Scanner;

public class HomeWork {
    public static void main(String[] args) {
        System.out.println("HomeWork\n");
/*        System.out.println("1. Реализуйте метод greetings(), который при вызове должен отпечатать в столбец 4 слова: Hello, World, from, Java");
        System.out.println("Результат:");
        greetings();

        System.out.println("\n2. Реализуйте метод checkSign(..), принимающий в качестве аргументов 3 int переменные a, b и c. Метод должен посчитать их сумму, и если она больше или равна 0, то вывести в консоль сообщение “Сумма положительная”, в противном случае - “Сумма отрицательная”;");
        checkSign(-1, -8, 3);

        System.out.println("\n3. Реализуйте метод selectColor() в теле которого задайте int переменную data с любым начальным значением. Если data меньше 10 включительно, то в консоль должно быть выведено сообщение “Красный”, если от 10 до 20 включительно, то “Желтый”, если больше 20 - “Зеленый”;");
        selectColor();

        System.out.println("\n4. Реализуйте метод compareNumbers(), в теле которого объявите две int переменные a и b с любыми начальными значениями. Если a больше или равно b, то необходимо вывести в консоль сообщение “a >= b”, в противном случае “a < b”;");
        compareNumbers();

        System.out.println("\n5. Создайте метод addOrSubtractAndPrint(int initValue, int delta, boolean increment). Если increment = true, то метод должен к initValue прибавить delta и отпечатать в консоль результат, в противном случае - вычесть;");
        addOrSubtractAndPrint(14, -3, false);
*/
        System.out.println("1. Реализуйте метод greetings(), который при вызове должен отпечатать в столбец 4 слова: Hello, World, from, Java");
        System.out.println("2. Реализуйте метод checkSign(..), принимающий в качестве аргументов 3 int переменные a, b и c. Метод должен посчитать их сумму, и если она больше или равна 0, то вывести в консоль сообщение “Сумма положительная”, в противном случае - “Сумма отрицательная”;");
        System.out.println("3. Реализуйте метод selectColor() в теле которого задайте int переменную data с любым начальным значением. Если data меньше 10 включительно, то в консоль должно быть выведено сообщение “Красный”, если от 10 до 20 включительно, то “Желтый”, если больше 20 - “Зеленый”;");
        System.out.println("4. Реализуйте метод compareNumbers(), в теле которого объявите две int переменные a и b с любыми начальными значениями. Если a больше или равно b, то необходимо вывести в консоль сообщение “a >= b”, в противном случае “a < b”;");
        System.out.println("5. Создайте метод addOrSubtractAndPrint(int initValue, int delta, boolean increment). Если increment = true, то метод должен к initValue прибавить delta и отпечатать в консоль результат, в противном случае - вычесть;");


        System.out.println("\nВведите число от 1 до 5");
        Scanner sc = new Scanner(System.in);
        int userSelect = sc.nextInt();
        switch (userSelect) {
            case 1:
                System.out.println("Результат:");
                greetings();
                break;
            case 2:
                checkSign((int)(Math.random()*21-10), (int)(Math.random()*21-10), (int)(Math.random()*21-10));
                break;
            case 3:
                selectColor();
                break;
            case 4:
                compareNumbers();
                break;
            case 5:
                addOrSubtractAndPrint((int)(Math.random()*21-10), (int)(Math.random()*21-10), (int)(Math.random()*21-10)<10?true:false);
                break;
            default:
                System.out.println("Введено число вне диапазона. Выход");
                break;
        }
    }

    public static void greetings(){
        System.out.println("Hello\nworld\nfrom\nJava");
    }

    public static void checkSign(int a, int b, int c) {
        System.out.println("Значение переменных a = "+a+", b = "+b+", c= "+c);
        System.out.println("Результат:");
        if ((a + b + c) >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    public static void selectColor(){
        int data = (int)(Math.random()*41-10);

        System.out.println("Значение переменной data = "+data);
        System.out.println("Результат:");
        if (data <=10){
            System.out.println("Красный");
        }else if (data > 10 && data <= 20){
            System.out.println("Желтый");
        }else System.out.println("Зеленый");
    }

    public static void compareNumbers(){
        int a = (int)(Math.random()*21-10);
        int b = (int)(Math.random()*21-10);
        System.out.println("Значение переменных a = "+a+", b = "+b);
        System.out.println("Результат:");
        if (a >= b){
            System.out.println("a >= b");
        }else {
            System.out.println("a < b");
        }
    }

    public static void addOrSubtractAndPrint(int initValue, int delta, boolean increment){
        System.out.println("Значение переменных initValue = "+initValue+", delta = "+delta+", increment= "+increment);
        System.out.println("Результат:");
        if (increment) {
            System.out.println("Сумма initValue + delta = "+(initValue+delta));
        } else {
            System.out.println("Разница initValue - delta = "+(initValue-delta));
        }
    }
}
