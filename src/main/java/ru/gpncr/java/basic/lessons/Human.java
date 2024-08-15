package ru.gpncr.java.basic.lessons;

public class Human {
    private static final double EXPENSES_HUMAN = 1.5;
    private String name;
    private Transport currentTransport;
    private double strength;

    public Human(String name, double strength) {
        this.name = name;
        this.strength = strength;
    }

    public void upTransport(Transport transport) {

        if (transport == null) {
            System.out.println(name + " не может встать с транспорта ");
            return;
        }
        if (currentTransport != null && currentTransport.equals(transport)) {
            System.out.println(name + " встал с транспорта: " + transport.getType());
            this.currentTransport = null;
        } else {


            System.out.println(name +
                    (currentTransport != null
                            ? (" не может встать с транспорта: " + transport.getType() +
                            (transport.getBrand() != null ? ", Марка " + transport.getBrand() : "")
                            + ". Текущий транспорт: " + currentTransport.getType() +
                            (currentTransport.getBrand() != null ? ", Марка " + currentTransport.getBrand()
                                    : ""))
                            : " не передвигается на транспорте "));
        }
    }

    public void downTransport(Transport transport) {
        if (currentTransport != null) {
            System.out.println(name + " не может сесть в траспорт: " + transport.getType() + ", текущий транспорт: " + currentTransport.getType());
        } else {
            this.currentTransport = transport;
            System.out.println(name + " сел на транспорт: " + transport.getType());
        }
    }

    public boolean move(int distance, Terrain terrain) {
        if (currentTransport != null) {
            boolean canMove = currentTransport.move(distance, terrain);
            if (canMove && currentTransport.getType().equalsIgnoreCase("Велосипед")) {
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
            }
            return canMove;
        } else {
            System.out.println(name + " идет пешком на " + distance + " км.");
            return true;
        }
    }

    public void printInfo() {
        System.out.println(name +
                (currentTransport != null ? " передвигается на транспорте " + currentTransport.getType() : " не передвигается на транспорте "));
    }

    public String getName() {
        return name;
    }

    public String getCurrentTransport() {
        return currentTransport.getType();
    }
}
