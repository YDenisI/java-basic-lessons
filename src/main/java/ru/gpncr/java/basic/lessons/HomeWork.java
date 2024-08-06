package ru.gpncr.java.basic.lessons;

public class HomeWork {
    public static void main(String[] args) {
        Cat cat = new Cat("Mur", 3, 7, 21);

        cat.run(20);
        cat.run(1);
        cat.run(1);
        cat.info();
        cat.swim(33);
        cat.endurance = 21;
        cat.run(20);
        cat.info();

        Dog dog = new Dog("Jack", 10, 15, 300);

        dog.info();
        dog.run(100);
        dog.info();
        dog.swim(100);
    }
}
