package ru.gpncr.java.basic.lessons;

import java.util.*;

public class PhoneBook {
    private Map<FullName, Set<String>> phoneBook;

    public PhoneBook() {
        phoneBook = new HashMap<>();
    }

    public void add(FullName fullName, String phoneNumber) {
        Set<String> phoneNumbers = phoneBook.get(fullName);
        if (phoneNumbers == null) {
            phoneNumbers = new HashSet<>();
            phoneNumbers.add(phoneNumber);
            phoneBook.put(fullName, phoneNumbers);
        } else
            phoneNumbers.add(phoneNumber);
    }

    public Set<String> find(FullName fullName) {
        return phoneBook.getOrDefault(fullName, Collections.emptySet());
    }


    public List<String> find(String surname) {
        List<String> setNumbers = new ArrayList<>();
        for (FullName keys : phoneBook.keySet()) {
            if (keys.getSurname().equalsIgnoreCase(surname)) {
                setNumbers.addAll(phoneBook.get(keys));
            }
        }
        return setNumbers;
    }

    public boolean containsPhoneNumber(String phoneNumber) {
        for (Set<String> phoneNumbers : phoneBook.values()) {
            if (phoneNumbers.contains(phoneNumber)) {
                return true;
            }
        }
        return false;
    }
}

