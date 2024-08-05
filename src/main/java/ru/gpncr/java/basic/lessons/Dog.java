package ru.gpncr.java.basic.lessons;


public class Dog extends Animal {

    public static final int EXPENSES = 2;

    public Dog(String name, double swimSpeed, double runSpeed, int endurance) {
        super(name, swimSpeed, runSpeed, endurance);
    }

    @Override
    public String getChildClass() {
        return "Собака";
    }

    @Override
    public double swim(int distance) {
        double t = 0;
        if (endurance > 0) isTired = false;
        if (isTired) {
            System.out.println("Собака " + name + " устала");
            return -1;
        }
        System.out.println(endurance);

        int requiredEndurance = distance * EXPENSES;
        System.out.println(requiredEndurance);
        if (endurance < requiredEndurance) {
            isTired = true;
            System.out.println("Собаке " + name + " не хватает выносливости для плавания на дистанцию " + distance);
            return -1;
        }

        t = distance / swimSpeed;
        endurance -= requiredEndurance;
        System.out.println("Собака " + name + " проплыла " + distance + " м. за " + String.format("%.3f", t) + " секунд(ы)");
        return t;
    }
}
