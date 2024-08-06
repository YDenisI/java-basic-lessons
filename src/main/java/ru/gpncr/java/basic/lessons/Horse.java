package ru.gpncr.java.basic.lessons;

public class Horse extends Animal {

    public static final int EXPENSES_SWIM = 4;
    public static final int EXPENSES_RUN = 1;

    public Horse(String name, double swimSpeed, double runSpeed, int endurance) {
        super(name, swimSpeed, runSpeed, endurance, "Лошадь");
        swimEnduranceCosts = EXPENSES_SWIM;
        runEnduranceCosts = EXPENSES_RUN;
    }
}