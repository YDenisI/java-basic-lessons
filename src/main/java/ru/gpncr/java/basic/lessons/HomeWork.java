package ru.gpncr.java.basic.lessons;

public class HomeWork {
    public static void main(String[] args) {
        PhoneBook pb = new PhoneBook();

        FullName name1 = new FullName("Иван", "Иванов", "Иванович");
        FullName name2 = new FullName("Сергей", "Осипов", "Петрович");
        FullName name3 = new FullName("Сергей", "Иванов", "Адольфович");

        pb.add(name1, "173-156");
        pb.add(name1, "777-012");
        pb.add(name2, "569-670");
        pb.add(name3, "569-660");

        System.out.println("Номера для Иванов Иван: " + pb.find(name1));
        System.out.println("Номера для Осипов Сергей: " + pb.find(name2));
        System.out.println("Номера для Осипов Сергей: " + pb.find(name3));
        System.out.println("Номера для Марамыгин Алексей: " + pb.find(new FullName("Алексей", "Марамыгин", "Александрович")));

        String phoneNumber = "173-156";
        System.out.println("Тел. книга " + (pb.containsPhoneNumber(phoneNumber) ? "содержит " + phoneNumber : "не содержит " + phoneNumber) + "номер");
        phoneNumber = "456-789";
        System.out.println("Тел. книга " + (pb.containsPhoneNumber(phoneNumber) ? "содержит " + phoneNumber : "не содержит " + phoneNumber) + "номер");

        System.out.println("Номера для Иванов : " + pb.find("Иванов"));

    }
}
