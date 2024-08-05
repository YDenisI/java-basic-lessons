package ru.gpncr.java.basic.lessons;

public class Horse extends Animal {

    public static final int EXPENSES = 4;

    public Horse(String name, double swimSpeed, double runSpeed, int endurance) {
        super(name, swimSpeed, runSpeed, endurance);
    }

    @Override
    public String getChildClass() {
        return "Лошадь";
    }

    @Override
    public double swim(int distance) {
        double t = 0;
        if (endurance > 0) isTired = false;
        if (isTired) {
            System.out.println("Лошадь " + name + " устала");
            return -1;
        }
        int requiredEndurance = distance * EXPENSES;
        if (endurance < requiredEndurance) {
            isTired = true;
            System.out.println("Лошади " + name + " не хватает выносливости для плавания на дистанцию " + distance);
            return -1;
        }

        t = distance / swimSpeed;
        endurance -= requiredEndurance;
        System.out.println("Лошадь " + name + " проплыла " + distance + " м. за " + String.format("%.3f", t) + " секунд(ы)");
        return t;
    }

}