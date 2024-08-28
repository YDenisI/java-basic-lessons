package ru.gpncr.java.basic.lessons;

public class HomeWork {
    public static void main(String[] args) {
        PersonDataBase dataBase = new PersonDataBase();

        Person person1 = new Person("Denis", Position.MANAGER, 1L);
        Person person2 = new Person("John", Position.DEVELOPER, 2L);

        dataBase.add(person1);
        dataBase.add(person2);

        System.out.println(dataBase.findById(1L).getName());
        System.out.println(dataBase.isManager(person1));
        System.out.println(dataBase.isEmployee(2L));
    }
}
