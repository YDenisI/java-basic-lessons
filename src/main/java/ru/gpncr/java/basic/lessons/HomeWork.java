package ru.gpncr.java.basic.lessons;


public class HomeWork {
    public static void main(String[] args) {
        BoxGen<Apple> appleBox = new BoxGen<>();
        appleBox.addFruit(new Apple());
        appleBox.addFruit(new Apple());

        BoxGen<Orange> orangeBox = new BoxGen<>();
        orangeBox.addFruit(new Orange());
        orangeBox.addFruit(new Orange());
        orangeBox.addFruit(new Orange());

        System.out.println("Вес коробки с яблоками: " + appleBox.weight());
        System.out.println("Вес коробки с апельсинами: " + orangeBox.weight());

        System.out.println("Сравнение коробок: " + appleBox.compare(orangeBox));

        appleBox.transferFruitsOneKind(appleBox);

        BoxGen<Fruit> boxFruit = new BoxGen<>();
        boxFruit.addFruit(new Orange());

        appleBox.transferFruitsToBoxFruits(boxFruit);
        orangeBox.transferFruitsToBoxFruits(boxFruit);

        System.out.println("Количество фруктов в коробке после объединения: " + boxFruit.getFruitCount());
    }
}
