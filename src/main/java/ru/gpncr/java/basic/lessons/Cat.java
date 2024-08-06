package ru.gpncr.java.basic.lessons;

public class Cat {
    private int appetite;
    private String name;
    private boolean satiety;

    public Cat(int appetite, String name) {

        this.appetite = appetite;
        this.name = name;
        this.satiety = false;
    }

    public int getAppetite() {
        return appetite;
    }

    public void setAppetite(int appetite) {
        this.appetite = appetite;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSatiety() {
        return satiety;
    }

    public void setSatiety(boolean satiety) {
        this.satiety = satiety;
    }

    public void eat(Plate plate) {

        if (plate.reduceFood(appetite, true)) {
            satiety = true;
            System.out.println("Кот по имени " + name + " поел");
        } else System.out.println("Кот по имени " + name + " не поел. Еды недостаточно");
    }

    public void info() {
        System.out.println("Кот по имени " + name + (satiety ? " сыт" : " голоден"));
    }
}
