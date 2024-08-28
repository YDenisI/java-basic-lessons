package ru.gpncr.java.basic.lessons;

import java.util.Objects;

public class FullName {
    private String name;
    private String surname;
    private String lastName;

    public FullName(String name, String surname, String lastName) {
        this.name = name;
        this.surname = surname;
        this.lastName = lastName;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FullName fullName = (FullName) o;
        return Objects.equals(name, fullName.name) && Objects.equals(surname, fullName.surname) && Objects.equals(lastName, fullName.lastName);
    }

    @Override
    public int hashCode() {
        return super.hashCode() * 31 + name == null ? 0 : name.hashCode() + surname == null ? 0 : surname.hashCode() + lastName == null ? 0 : lastName.hashCode();
    }
}