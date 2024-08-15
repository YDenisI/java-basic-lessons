package ru.gpncr.java.basic.lessons;

public class Human {

    private String name;
    private Transport currentTransport;

    public Human(String name) {
        this.name = name;
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
            return currentTransport.move(distance, terrain);
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
