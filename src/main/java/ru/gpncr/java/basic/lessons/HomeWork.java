package ru.gpncr.java.basic.lessons;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HomeWork {
    public static void main(String[] args) {
        System.out.println("1. Реализуйте метод, принимающий в качестве аргументов числа min и max, и возвращающий ArrayList с набором последовательных значений в указанном диапазоне (min и max включительно, шаг - 1);");
        System.out.println(fillList(4.5, 10));

        List<Integer> ls = new ArrayList<>();
        ls.add(-2);
        ls.add(10);
        ls.add(11);
        ls.add(-32);
        ls.add(14);
        ls.add(3);
        ls.add(-7);
        ls.add(19);
        ls.add(-4);

        System.out.println("2. Сумма элементов списка " + ls + " больше 5 равно " + sumElementsList(ls));
        rewriteElementsList(ls, 44);
        System.out.println("1 " + ls);
        increaseElementsList(ls, 10);
        System.out.println("2 " + ls);

        Employee emp1 = new Employee("Jack", 15);
        Employee emp2 = new Employee("John", 22);
        Employee emp3 = new Employee("Jimm", 38);
        Employee emp4 = new Employee("Tom", 24);

        List<Employee> listEmploees = new ArrayList<Employee>();

        listEmploees.add(emp1);
        listEmploees.add(emp2);
        listEmploees.add(emp3);
        listEmploees.add(emp4);
        System.out.println(getNameEployees(listEmploees));
        List employees = getEployees(listEmploees, 20);
        for (Iterator iterator = employees.iterator(); iterator.hasNext(); ) {
            Employee emp = (Employee) iterator.next();
            System.out.println(emp.getName() + " Age: " + emp.getAge());
        }
        getMiddleAgeEployees(listEmploees, 15);
        Employee emp = getYoungEmployee(listEmploees);
        System.out.println(emp.getName() + " " + emp.getAge());
    }

    public static List fillList(double min, double max) {
        if (max <= min) {
            System.out.println("Максимальное число (второй аргумент метода) меньше, либо равно минимального числа (первый аргумент метода)");
            return null;
        }
        List<Double> ls = new ArrayList<>();
        for (double i = min; i <= max; i++) {
            ls.add(i);
        }
        return ls;
    }

    public static int sumElementsList(List ls) {
        int sum = 0;

        if (ls == null) {
            System.out.println("Список сотрудников пуст");
            return sum;
        }

        for (Iterator iterator = ls.iterator(); iterator.hasNext(); ) {
            int elem = (int) iterator.next();
            if (elem > 5) sum += elem;
        }
        return sum;
    }

    public static void rewriteElementsList(List ls, int count) {
        if (ls == null) {
            System.out.println("Список сотрудников пуст");
            return;
        }
        for (int i = 0; i < ls.size(); i++) {
            ls.set(i, count);
        }
    }

    public static void increaseElementsList(List<Integer> ls, int count) {
        if (ls == null) {
            System.out.println("Список сотрудников пуст");
            return;
        }
        for (int i = 0; i < ls.size(); i++) {
            ls.set(i, ls.get(i) + count);
        }
    }

    public static List getNameEployees(List<Employee> ls) {

        if (ls == null) {
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

    public static List getEployees(List<Employee> ls, double age) {

        if (ls == null) {
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

    public static void getMiddleAgeEployees(List<Employee> ls, double middleAge) {

        if (ls == null) {
            System.out.println("Список сотрудников пуст");
            return;
        }
        double middleAgeEmployees = 0;
        int cnt = 0;
        for (Iterator iterator = ls.iterator(); iterator.hasNext(); ) {
            Employee emp = (Employee) iterator.next();
            middleAgeEmployees += emp.getAge();
            cnt++;
        }

        if ((middleAgeEmployees / cnt) > middleAge) {
            System.out.println("Средний возраст сотрудников превышает указанный аргумент");
        } else {
            System.out.println("Средний возраст сотрудников не превышает указанный аргумент");
        }
    }

    public static Employee getYoungEmployee(List<Employee> ls) {

        if (ls == null) {
            System.out.println("Список сотрудников пуст");
            return null;
        }
        Employee empoyee = ls.get(0);
        double minAge = ls.get(0).getAge();
        for (Iterator iterator = ls.iterator(); iterator.hasNext(); ) {
            Employee emp = (Employee) iterator.next();
            System.out.println(minAge);
            if (emp.getAge() < minAge) {
                empoyee = emp;
            }
        }
        return empoyee;
    }
}

