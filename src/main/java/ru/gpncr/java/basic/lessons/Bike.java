package ru.gpncr.java.basic.lessons;

public class Bike implements Transport {
    private static final String BIKE = "Велосипед";

    @Override
    public boolean move(int distance, Terrain terrain) {
        if (terrain == Terrain.SWAMP) {
            System.out.println("Велосипед не может передвигаться по местности: " + terrain.getType());
            return false;
        }
        return true;
    }

    @Override
    public String getType() {
        return BIKE;
    }

    @Override
    public String getBrand() {
        return null;
    }
}
