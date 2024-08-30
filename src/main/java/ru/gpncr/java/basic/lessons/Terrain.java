package ru.gpncr.java.basic.lessons;

public enum Terrain {
    DENSE_FOREST("Густой лес"),
    PLAIN("Равнина"),
    SWAMP("Болото");

    private final String terrain;

    Terrain(String terrain) {
        this.terrain = terrain;
    }

    public String getType() {
        return terrain;
    }
}
