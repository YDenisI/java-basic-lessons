package ru.gpncr.java.basic.lessons;


public abstract class Animal {

    public static final int EXPENSES = 1;

    protected String name;
    protected double swimSpeed;
    protected double runSpeed;
    protected int endurance;
    protected boolean isTired;

    public Animal(String name, double swimSpeed, double runSpeed, int endurance) {
        this.name = name;
        this.swimSpeed = swimSpeed;
        this.runSpeed = runSpeed;
        this.endurance = endurance;
    }

    abstract String getChildClass();

    abstract double swim(int distance);

    public double run(int distance) {
        double t = 0;

        int requiredEndurance = distance * EXPENSES;
        if (endurance > 0) isTired = false;
        if (isTired) {
            System.out.println("Животное " + getChildClass() + "по имени " + name + " устало");
            return -1;
        }

        if (endurance < requiredEndurance) {
            isTired = true;
            System.out.println("Животному " + getChildClass() + " по имени " + name + " не хватает выносливости для бега на дистанцию " + distance + " м.");
            return -1;
        }

        t = distance / runSpeed;
        endurance -= requiredEndurance;

        System.out.println("Животное " + getChildClass() + " по имени " + name + " пробежало " + distance + " м. за " + String.format("%.3f", t) + " секунд(ы)");
        return t;
    }

    public void info() {
        System.out.println("\nЖивотное - " + getChildClass() + "\nИмя - " +
                name + "\nСкорость бега - " + runSpeed + "\nСкорость плавания - " +
                swimSpeed + "\nСостояние - " + (isTired ? " усталость " : " в норме"));
    }
}
