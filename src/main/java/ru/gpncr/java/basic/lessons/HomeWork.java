package ru.gpncr.java.basic.lessons;

import java.time.Year;

public class HomeWork {
    public static void main(String[] args) {
        System.out.println("HomeWork");
        User[] users = {new User(2005, "Maks", "Maksimov", "Maksimovich", "test1@test.ru"),
                new User(2012, "Ivan", "Ivanov", "Ivanovich", "test2@test.ru"),
                new User(1990, "Den", "Denisov", "Denisovich", "test3@test.ru"),
                new User(1971, "Alex", "Alekseev", "Alekseevich", "test4@test.ru"),
                new User(2008, "John", "Uick", "", "test5@test.ru"),
                new User(2020, "Tom", "Aspinal", "", "test6@test.ru"),
                new User(1989, "Bob", "Marley", "", "test7@test.ru"),
                new User(1964, "Joseph", "Tarasov", "Romanovich", "test8@test.ru"),
                new User(2000, "Chip", "Chupa", "Chups", "test9@test.ru"),
                new User(2012, "Donald", "Duck", "", "test10@test.ru")};

        System.out.println("\nПользователи старше 40 лет");
        for (User user : users) {
            if ((Year.now().getValue() - user.getBirthDate()) > 40) {
                user.printInfo();
                System.out.println();
            }
        }

        Box box = new Box(20, 10, 8, "red");

        box.prinfInfo();
        box.setColor("green");
        box.prinfInfo();
        box.putItem("Ball");
        box.prinfInfo();
        box.open();
        box.putItem("Ball1");
        box.prinfInfo();
        box.close();
        box.putItem("Ball2");
        box.prinfInfo();
        box.removeItem("Ball2");
        box.open();
        box.removeItem("Ball2");
        box.putItem("Ball2");
        box.prinfInfo();
        box.removeItem("Ball1");
        box.prinfInfo();

        // I-ый вариант
       /* box.prinfInfo1();
        box.open();
        box.prinfInfo1();
        box.putSubject("Racket");
        // box.putSubject("Ball");
        box.putSubject("Ball");
        box.prinfInfo1();
        box.deleteSubject("Pencil");
        box.removeSubject("Ball");
        box.prinfInfo1();
        box.deleteSubject("Ball");
        box.prinfInfo1();
        box.close();
        box.removeSubject("Ball");
        box.removeSubject("Racket");
        box.prinfInfo1();*/
        // II-ой вариант
       /* box.prinfInfo2();
        box.open();
        box.prinfInfo2();
        box.addSubject("Ball");
        box.addSubject("Racket");
        box.addSubject("Racket");
        box.delSubject("Pencil");
        box.delSubject("Ball");
        box.prinfInfo2();
        box.close();
        box.delSubject("Ball");
        box.prinfInfo2();*/
    }
}
