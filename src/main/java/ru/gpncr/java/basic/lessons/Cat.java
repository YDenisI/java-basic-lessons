package ru.gpncr.java.basic.lessons;


public class Cat extends Animal {


    public Cat(String name, double swimSpeed, double runSpeed, int endurance) {
        super(name, swimSpeed, runSpeed, endurance);
    }

    @Override
    public String getChildClass() {
        return "Кошка";
    }

    @Override
    public double swim(int distance) {
        System.out.println("Кошки плавать не умеют");
        return -1;
    }
}
