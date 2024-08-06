package ru.gpncr.java.basic.lessons;


public class Cat extends Animal {

    public static final int EXPENSES_SWIM = 0;
    public static final int EXPENSES_RUN = 1;

    public Cat(String name, double swimSpeed, double runSpeed, int endurance) {
        super(name, swimSpeed, runSpeed, endurance, "Кот");
        swimEnduranceCosts = EXPENSES_SWIM;
        runEnduranceCosts = EXPENSES_RUN;
    }
}
