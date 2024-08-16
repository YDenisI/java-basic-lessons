package ru.gpncr.java.basic.lessons;

public class Employee {

    private String name;
    private double age;

    public Employee(String name, double age) {
        this.name = name;
        this.age = age;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }
}
