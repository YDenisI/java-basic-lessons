package ru.gpncr.java.basic.lessons;

public class Horse implements Transport {
    private static final String HORSE = "Лошадь";
    public static final int EXPENSES_RUN = 2;
    private int strength;

    public Horse(int strength) {
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
            System.out.println("Лошадь не может передвигаться по местности: " + terrain.getType());
            return false;
        }
        if (strength <= 0) {
            System.out.println("Лошадь устала и не может перемещаться!");
            return false;
        }
        double requiredEndurance = distance * EXPENSES_RUN;
        if ((strength - requiredEndurance) >= 0) {
            strength -= requiredEndurance;
            System.out.println("Лошадь переместилась на " + distance + " м. по местности: " + terrain.getType());
        } else {
            double possibleDistance = strength * EXPENSES_RUN;
            strength = 0;
            System.out.println("Лошадь смогла переместиться только на  " + possibleDistance + " м. по местности: " + terrain.getType() +
                    ". Лошадь устала");
            return false;
        }
        return true;
    }

    @Override
    public String getType() {
        return HORSE;
    }

    @Override
    public String getBrand() {
        return null;
    }
}
