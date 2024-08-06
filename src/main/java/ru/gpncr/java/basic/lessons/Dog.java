package ru.gpncr.java.basic.lessons;


public class Dog extends Animal {

    public static final int EXPENSES_SWIM = 2;
    public static final int EXPENSES_RUN = 1;

    public Dog(String name, double swimSpeed, double runSpeed, int endurance) {
        super(name, swimSpeed, runSpeed, endurance, "Собака");
        swimEnduranceCosts = EXPENSES_SWIM;
        runEnduranceCosts = EXPENSES_RUN;
    }
}
