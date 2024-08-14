package ru.gpncr.java.basic.lessons;

public class Bike implements Transport {
    private static final String BIKE = "Велосипед";
    private int strength;
    public static final double EXPENSES_HUMAN = 1.5;

    public Bike(int strength) {
        this.strength = strength;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public boolean move(int distance, Terrain terrain) {
        if (terrain == Terrain.SWAMP) {
            System.out.println("Велосипед не может передвигаться по местности: " + terrain.getType());
            return false;
        }
        if (strength <= 0) {
            System.out.println("Человек устал и не может двигаться на велосипеде!");
            return false;
        }
        double requiredEndurance = distance * EXPENSES_HUMAN;
        if ((strength - requiredEndurance) > 0) {
            strength -= requiredEndurance;
            System.out.println("Человек на велосипеде переместился на " + distance + " м. по местности: " + terrain.getType());
        } else {
            double possibleDistance = strength * EXPENSES_HUMAN;
            strength = 0;
            System.out.println("Человек на велосипеде смог переместиться только на  " + possibleDistance + " м. по местности: " + terrain.getType() +
                    ". Человек устал");
            return false;
        }
        return true;
    }

    @Override
    public String getType() {
        return BIKE;
    }
}
