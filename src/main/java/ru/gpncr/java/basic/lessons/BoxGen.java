package ru.gpncr.java.basic.lessons;

import java.util.ArrayList;
import java.util.List;

public class BoxGen<T extends Fruit> {
    private List<T> fruits;

    public BoxGen() {
        this.fruits = new ArrayList<>();
    }

    public void addFruit(T fruit) {
        fruits.add(fruit);
    }

    public double weight() {
        double totalWeight = 0.0;
        for (T fruit : fruits) {
            totalWeight += fruit.getWeight();
        }
        return totalWeight;
    }

    public boolean compare(BoxGen<?> otherBox) {
        return Math.abs(this.weight() - otherBox.weight()) < 0.001;
    }

    public void transferFruitsToBoxFruits(BoxGen<Fruit> anotherBox) {
        for (T fruit : fruits) {
            anotherBox.addFruit(fruit);
        }
        this.fruits.clear();
    }

    public void transferFruitsOneKind(BoxGen<T> anotherBox) {
        if (this == anotherBox) {
            System.out.println("Нельзя пересыпать фрукты в ту же коробку.");
            return;
        }

        anotherBox.fruits.addAll(this.fruits);
        this.fruits.clear();
    }

    public int getFruitCount() {
        return fruits.size();
    }
}
