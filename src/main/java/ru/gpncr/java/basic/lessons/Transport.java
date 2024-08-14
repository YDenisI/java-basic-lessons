package ru.gpncr.java.basic.lessons;

public interface Transport {

    boolean move(int distance, Terrain terrain);

    String getType();
}
