package ru.gpncr.java.basic.lessons;

public class HomeWork {
    public static void main(String[] args) {
        Plate plate = new Plate(21);

        //plate.addFood(3);
        plate.reduceFood(1, false);
        System.out.println(plate.getStatePlate());
        plate.addFood(6);
        System.out.println(plate.getStatePlate());

        Cat[] cats = {new Cat(7, "Din"),
                new Cat(5, "Tom"),
                new Cat(10, "Jerry"),
                new Cat(4, "Bim")};

        for (Cat cat : cats) {
            if (!cat.isSatiety()) cat.eat(plate);
            cat.info();
        }
        System.out.println(plate.getStatePlate());
        plate.addFood(2);

        plate.reduceFood(6, false);
        System.out.println(plate.getStatePlate());

        plate.addFood(10);
        System.out.println(plate.getStatePlate());
        for (Cat cat : cats) {
            if (!cat.isSatiety()) cat.eat(plate);
            cat.info();
        }

        plate.addFood(22);
        plate.addFood(7);

        for (Cat cat : cats) {
            if (!cat.isSatiety()) cat.eat(plate);
            cat.info();
        }

        System.out.println(plate.getStatePlate());

        // Допустим по истечению екоторого времени один из котов проголодался
        cats[1].setSatiety(false);

        for (Cat cat : cats) {
            if (!cat.isSatiety()) cat.eat(plate);
            cat.info();
        }

        System.out.println(plate.getStatePlate());
    }
}
