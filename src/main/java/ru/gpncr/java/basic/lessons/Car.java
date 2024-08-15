package ru.gpncr.java.basic.lessons;

public class Car implements Transport {
    private static final int CAPACITY = 60;
    private static final String CAR = "Машина";
    private static final double USAGE_FUEL = 10;
    
    private double fuel;
    private String brande;

    public Car(int fuel, String brand) {
        if (fuel < CAPACITY) {
            this.fuel = fuel;
        } else {
            this.fuel = CAPACITY;
            System.out.println("Машина заправлена полностью, вместимость бака " + CAPACITY + " литров");
        }
        this.brande = brand;
    }

    public double getFuel() {
        return fuel;
    }

    public String getBrande() {
        return brande;
    }

    public void setFuel(double fuel) {
        if (fuel < CAPACITY) {
            this.fuel = fuel;
        } else {
            this.fuel = CAPACITY;
            System.out.println("Машина заправлена полностью, вместимость бака " + CAPACITY + " литров");
        }
    }

    @Override
    public boolean move(int distance, Terrain terrain) {
        if (terrain == Terrain.DENSE_FOREST || terrain == Terrain.SWAMP) {
            System.out.println("Машина не может передвигаться по местности: " + terrain.getType());
            return false;
        }
        if (fuel <= 0) {
            System.out.println("Нет бензина для передвижения!");
            return false;
        }
        double requiredFuel = distance * 0.1;
        if ((fuel - requiredFuel) >= 0) {
            fuel -= requiredFuel;
            System.out.println("Машина переместилась на " + distance + " км. по местности: " + terrain.getType());
        } else {
            double possibleDistance = fuel * USAGE_FUEL;
            fuel = 0;
            System.out.println("Машина смогла переместиться только на  " + possibleDistance + " км. по местности: " + terrain.getType() +
                    ". Нет бензина для передвижения, необходимо заправка машины");
            return false;
        }
        return true;
    }

    @Override
    public String getType() {
        return CAR;
    }

    @Override
    public String getBrand() {
        return brande;
    }

}
