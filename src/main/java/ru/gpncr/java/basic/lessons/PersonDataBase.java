package ru.gpncr.java.basic.lessons;

import java.util.HashMap;
import java.util.Map;

public class PersonDataBase {

    private Map<Long, Person> personMap;

    public PersonDataBase() {
        personMap = new HashMap<>();
    }

    public Person findById(Long id) {
        return personMap.get(id);
    }

    public void add(Person person) {
        personMap.put(person.getId(), person);
    }

    public boolean isManager(Person person) {
        if (person == null) return false;
        Position position = person.getPosition();
        return (position == Position.MANAGER) || (position == Position.DIRECTOR) ||
                (position == Position.BRANCH_DIRECTOR) || (position == Position.SENIOR_MANAGER);
    }

    public boolean isEmployee(Long id) {
        Person person = findById(id);
        if (person != null) {
            Position position = person.getPosition();
            return (position != Position.MANAGER) && (position != Position.DIRECTOR) &&
                    (position != Position.BRANCH_DIRECTOR) && (position != Position.SENIOR_MANAGER);
        }
        return false;
    }
}
