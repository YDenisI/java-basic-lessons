package ru.gpncr.java.basic.lessons;


public class Animal {

    public static final int EXPENSES_RUN = 1;

    protected String name;
    protected double swimSpeed;
    protected double runSpeed;
    protected int endurance;
    protected boolean isTired;
    protected String typeAnimal;
    protected int swimEnduranceCosts;
    protected int runEnduranceCosts;

    public Animal(String name, double swimSpeed, double runSpeed, int endurance, String typeAnimal) {
        this.name = name;
        this.swimSpeed = swimSpeed;
        this.runSpeed = runSpeed;
        this.endurance = endurance;
        this.typeAnimal = typeAnimal;
    }

    public double swim(int distance) {
        double t = 0;

        if (swimEnduranceCosts == 0)
            System.out.println("Животное " + typeAnimal + " не умеет плавать");

        if (endurance > 0) isTired = false;
        if (isTired) {
            System.out.println("Животное " + typeAnimal + " по имени " + name + " устало");
            return -1;
        }

        int requiredEndurance = distance * swimEnduranceCosts;

        if (endurance < requiredEndurance) {
            isTired = true;
            endurance = 0;
            System.out.println("Животному " + typeAnimal + " по имени " + name + " не хватает выносливости для плавания на дистанцию " + distance + " м. Усталость");
            return -1;
        }

        t = distance / swimSpeed;
        endurance -= requiredEndurance;
        System.out.println("Животное " + typeAnimal + " по имени " + name + " проплыло " + distance + " м. за " + String.format("%.3f", t) + " секунд(ы)");
        return t;
    }

    public double run(int distance) {
        double t = 0;

        int requiredEndurance = distance * runEnduranceCosts;
        if (endurance > 0) isTired = false;
        if (isTired) {
            System.out.println("Животное " + typeAnimal + "по имени " + name + " устало");
            return -1;
        }

        if (endurance < requiredEndurance) {
            isTired = true;
            endurance = 0;
            System.out.println("Животному " + typeAnimal + " по имени " + name + " не хватает выносливости для бега на дистанцию " + distance + " м. Усталость");
            return -1;
        }

        t = distance / runSpeed;
        endurance -= requiredEndurance;

        System.out.println("Животное " + typeAnimal + " по имени " + name + " пробежало " + distance + " м. за " + String.format("%.3f", t) + " секунд(ы)");
        return t;
    }

    public void info() {
        System.out.println("\nЖивотное - " + typeAnimal + "\nИмя - " +
                name + "\nСкорость бега - " + runSpeed + "\nСкорость плавания - " +
                swimSpeed + "\nСостояние - " + (isTired ? " усталость " : " в норме"));
    }
}
