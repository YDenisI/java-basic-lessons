package ru.gpncr.java.basic.lessons;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HomeWork {
    public static void main(String[] args) {
        System.out.println("1. Реализуйте метод, принимающий в качестве аргументов числа min и max, и возвращающий ArrayList с набором последовательных значений в указанном диапазоне (min и max включительно, шаг - 1);");
        System.out.println(fillList(4.5, 10));

        List<Integer> ls = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ls.add((int) (Math.random() * 28 - 16));
        }

        System.out.println("2. Сумма элементов списка " + ls + " больше 5 равно " + sumElementsList(ls));
        System.out.println("3. Реализуйте метод, принимающий в качестве аргументов целое число и ссылку на список, метод должен переписать каждую заполненную ячейку списка указанным числом ");
        System.out.println("Список \nбыло- " + ls);
        rewriteElementsList(ls, 44);
        System.out.println("стало - " + ls);
        System.out.println("4. Реализуйте метод, принимающий в качестве аргументов целое число и ссылку на список, увеличивающий каждый элемент списка на указанное число ");
        ls = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ls.add((int) (Math.random() * 28 - 16));
        }
        System.out.println("Список \nбыло- " + ls);
        increaseElementsList(ls, 10);
        System.out.println("стало - " + ls);

        Employee emp1 = new Employee("Jack", 15);
        Employee emp2 = new Employee("John", 22);
        Employee emp3 = new Employee("Jimm", 38);
        Employee emp4 = new Employee("Tom", 24);

        List<Employee> listEmploees = new ArrayList<Employee>();

        listEmploees.add(emp1);
        listEmploees.add(emp2);
        listEmploees.add(emp3);
        listEmploees.add(emp4);
        System.out.println("Список сотрудников ");
        for (Iterator iterator = listEmploees.iterator(); iterator.hasNext(); ) {
            Employee emp = (Employee) iterator.next();
            System.out.println("Name: " + emp.getName() + " Age: " + emp.getAge());
        }

        System.out.println("4. Реализуйте метод, принимающий в качестве аргумента список сотрудников, и возвращающий список их имен; ");
        System.out.println(" Результат - " + getNameEployees(listEmploees));

        System.out.println("5. Реализуйте метод, принимающий в качестве аргумента список сотрудников и минимальный возраст, и возвращающий список сотрудников, возраст которых больше либо равен указанному аргументу ");
        List employees = filterEmployeesByAge(listEmploees, 20);
        System.out.println("Результат");
        for (Iterator iterator = employees.iterator(); iterator.hasNext(); ) {
            Employee emp = (Employee) iterator.next();
            System.out.println(emp.getName() + " Age: " + emp.getAge());
        }
        System.out.println("6. Реализуйте метод, принимающий в качестве аргумента список сотрудников и минимальный средний возраст, и проверяющий что средний возраст сотрудников превышает указанный аргумент ");
        System.out.println("Результат: ");
        if (isAverageAgeGreater(listEmploees, 15)) {
            System.out.println("Средний возраст сотрудников превышает аргумент " + 15);
        }
        System.out.println("7. Реализуйте метод, принимающий в качестве аргумента список сотрудников, и возвращающий ссылку на самого молодого сотрудника ");
        System.out.println("Результат: ");
        Employee emp = getYoungEmployee(listEmploees);
        if (emp != null) {
            System.out.println("Name: " + emp.getName() + ", age: " + emp.getAge());
        }
    }

    public static ArrayList<Double> fillList(double min, double max) {
        if (max <= min) {
            System.out.println("Максимальное число (второй аргумент метода) меньше, либо равно минимального числа (первый аргумент метода)");
            return null;
        }
        ArrayList<Double> ls = new ArrayList<>();
        for (double i = min; i <= max; i++) {
            ls.add(i);
        }
        return ls;
    }

    public static int sumElementsList(List<Integer> ls) {
        int sum = 0;

        if (ls == null || ls.isEmpty()) {
            System.out.println("Список сотрудников пуст");
            return sum;
        }

        for (Iterator<Integer> iterator = ls.iterator(); iterator.hasNext(); ) {
            int elem = iterator.next();
            if (elem > 5) {
                sum += elem;
            }
        }
        return sum;
    }

    public static void rewriteElementsList(List ls, int count) {
        if (ls == null || ls.isEmpty()) {
            System.out.println("Список сотрудников пуст");
            return;
        }
        for (int i = 0; i < ls.size(); i++) {
            ls.set(i, count);
        }
    }

    public static void increaseElementsList(List<Integer> ls, int count) {
        if (ls == null || ls.isEmpty()) {
            System.out.println("Список сотрудников пуст");
            return;
        }
        for (int i = 0; i < ls.size(); i++) {
            ls.set(i, ls.get(i) + count);
        }
    }

    public static List<String> getNameEployees(List<Employee> ls) {

        if (ls == null || ls.isEmpty()) {
            System.out.println("Список сотрудников пуст");
            return null;
        }
        List<String> lsName = new ArrayList<>();

        for (Iterator iterator = ls.iterator(); iterator.hasNext(); ) {
            Employee emp = (Employee) iterator.next();
            lsName.add(emp.getName());
        }
        return lsName;
    }

    public static List<Employee> filterEmployeesByAge(List<Employee> ls, double age) {

        if (ls == null || ls.isEmpty()) {
            System.out.println("Список сотрудников пуст");
            return null;
        }
        List<Employee> lsEmployees = new ArrayList<>();

        for (Iterator iterator = ls.iterator(); iterator.hasNext(); ) {
            Employee emp = (Employee) iterator.next();
            if (emp.getAge() >= age) {
                lsEmployees.add(emp);
            }
        }
        return lsEmployees;
    }

    public static boolean isAverageAgeGreater(List<Employee> ls, double middleAge) {

        if (ls == null || ls.isEmpty()) {
            System.out.println("Список сотрудников пуст");
            return false;
        }
        double middleAgeEmployees = 0;
        for (Iterator iterator = ls.iterator(); iterator.hasNext(); ) {
            Employee emp = (Employee) iterator.next();
            middleAgeEmployees += emp.getAge();
        }

        return ((middleAgeEmployees / ls.size()) > middleAge) ? true : false;
    }

    public static Employee getYoungEmployee(List<Employee> ls) {

        if (ls == null || ls.isEmpty()) {
            System.out.println("Список сотрудников пуст");
            return null;
        }
        Employee employee = ls.get(0);
        double minAge = ls.get(0).getAge();
        for (Iterator iterator = ls.iterator(); iterator.hasNext(); ) {
            Employee emp = (Employee) iterator.next();
            if (emp.getAge() < minAge) {
                employee = emp;
            }
        }
        return employee;
    }
}

