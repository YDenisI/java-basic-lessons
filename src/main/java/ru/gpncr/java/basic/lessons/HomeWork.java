package ru.gpncr.java.basic.lessons;

public class HomeWork {
    public static void main(String[] args) {
        Transport car = new Car(10, "Nissan");
        Transport horse = new Horse(10);
        Transport terranVehicle = new TerrainVehicle(100);
        Transport bike = new Bike();

        Human human = new Human("Jack", 30);
        human.downTransport(bike);
        human.move(30, Terrain.PLAIN);
        human.move(30, Terrain.PLAIN);
        human.downTransport(car);
        human.downTransport(bike);
        Transport car1 = new Car(10, "Toyota");
        human.upTransport();
        human.printInfo();
        human.upTransport();
        human.upTransport();
      /*  human.printInfo();
        System.out.println(((Car) car).getFuel());
        human.move(30, Terrain.PLAIN);
        human.move(30, Terrain.PLAIN);
        human.move(30, Terrain.PLAIN);
        human.move(30, Terrain.PLAIN);
        human.move(30, Terrain.DENSE_FOREST);
        human.move(30, Terrain.SWAMP);
        human.move(30, Terrain.PLAIN);

        human.printInfo();

        human.upTransport(bike);
        human.printInfo();
        human.upTransport(car);

        human.downTransport(car);
        human.move(30, Terrain.PLAIN);

        System.out.println(((Car) car).getFuel());
        car.move(30, Terrain.PLAIN);

        ((Car) car).setFuel(100);
        System.out.println(((Car) car).getFuel());

        human.upTransport(car);
        human.downTransport(horse);
        human.move(30, Terrain.DENSE_FOREST);
        human.move(30, Terrain.SWAMP);
        human.move(30, Terrain.PLAIN);*/

    }
}
