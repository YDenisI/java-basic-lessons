package ru.gpncr.java.basic.lessons;


public class User {

    private int birthDate = 0;
    private String name = null;
    private String surname = null;
    private String lastname = null;
    private String email = null;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    public void setLastame(String lastname) {
        this.lastname = lastname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setBirthDate(int birthDate) {
        this.birthDate = birthDate;
    }

    public int getBirthDate() {
        return birthDate;
    }

    private void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public User(int birthDate, String name, String surname, String lastname, String email) {

        this.birthDate = birthDate;
        this.name = name;
        this.surname = surname;
        this.lastname = lastname;
        this.email = email;
    }

    public void printInfo() {

        System.out.println("ФИО: " + surname + " " + name + " " + lastname);//фамилия имя отчество
        System.out.println("Год рождения: " + birthDate);//год рождения
        System.out.println("e-mail: " + email);//email
    }
}