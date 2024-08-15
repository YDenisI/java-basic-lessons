package ru.gpncr.java.basic.lessons;

public class TerrainVehicle implements Transport {
    private static final String TERRAIN_VEHICLE = "Вездеход";
    private double fuel;
    private static final int CAPACITY = 100;
    private static final double USAGE_FUEL = 20;

    public TerrainVehicle(int fuel) {
        if (fuel < CAPACITY) {
            this.fuel = fuel;
        } else {
            this.fuel = CAPACITY;
            System.out.println("Вездеход заправлен полностью, вместимость бака " + CAPACITY + " литров");
        }
    }

    public double getFuel() {
        return fuel;
    }

    public void setFuel(double fuel) {
        if (fuel < CAPACITY) {
            this.fuel = fuel;
        } else {
            this.fuel = CAPACITY;
            System.out.println("Вездеход заправлен полностью, вместимость бака " + CAPACITY + " литров");
        }
    }

    @Override
    public boolean move(int distance, Terrain terrain) {
        if (fuel <= 0) {
            System.out.println("Нет бензина для передвижения!");
            return false;
        }
        double requiredFuel = distance * 0.1;
        if ((fuel - requiredFuel) >= 0) {
            fuel -= requiredFuel;
            System.out.println("Вездеход переместилсч на " + distance + " км. по местности: " + terrain.getType());
        } else {
            double possibleDistance = fuel * USAGE_FUEL;
            fuel = 0;
            System.out.println("Вездеход смогл переместиться только на  " + possibleDistance + " км. по местности: " + terrain.getType() +
                    ". Нет бензина для передвижения, необходимо заправить вездеход");
            return false;
        }
        return true;
    }

    @Override
    public String getType() {
        return TERRAIN_VEHICLE;
    }

    @Override
    public String getBrand() {
        return null;
    }
}
