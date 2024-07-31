package ru.gpncr.java.basic.lessons;

import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Box {

    private double length = 0;
    private double heigth = 0;
    private double width = 0;
    private String color = null;
    private boolean openclose = false;
    private String item = null;

    private String[] subject = null;
    private List listSubjects = null;

    public Box(double length, double heigth, double width, String color) {
        this.length = length;
        this.heigth = heigth;
        this.width = width;
        this.color = color;
    }

    public void open() {
        openclose = true;
    }

    public void close() {
        openclose = false;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getLength() {
        return length;
    }

    public double getHeigth() {
        return heigth;
    }

    public double getWidth() {
        return width;
    }

    public void prinfInfo() {

        System.out.println("Размеры коробки: длина = " + length + ", ширина = " + width + ", высота = " + heigth);
        System.out.println("Цвет коробки - " + color);

        if (openclose) System.out.println("Коробка открыта");
        else System.out.println("Коробка закрыта");

        System.out.println(item == null ? "Коробка пуста" : "В коробке находятся следующий предмет " + item);
    }

    public void putItem(String item) {

        if (!openclose) {
            System.out.println("Положить предмет" + item + " в коробку нельзя. Коробка закрыта");
            return;
        }
        if (this.item == null) {
            this.item = item;
            System.out.println("В коробку положили предмет " + item);
        } else
            System.out.println("Положить предмет " + item + " в коробку нельзя. Коробка не пустая");
    }

    public void removeItem(String item) {
        if (!openclose) {
            System.out.println("Убрать предмет " + item + " нельзя. Коробка закрыта");
            return;
        }
        if (this.item.equalsIgnoreCase(item)) {
            this.item = null;
            System.out.println("Коробка открыта, предмет " + item + " убран из коробки");
        } else System.out.println("Коробка открыта, но предмета " + item + " нет в коробке");
    }

/*
    public void prinfInfo1() {

        System.out.println("Размеры коробки: длина = " + length + ", ширина = " + width + ", высота = " + heigth);
        System.out.println("Цвет коробки - " + color);

        if (openclose) System.out.println("Коробка открыта");
        else System.out.println("Коробка закрыта");

        System.out.println(subject == null ? "Коробка пуста" : "В коробке находятся следующие предметы " + Arrays.deepToString(subject));
    }

    public void prinfInfo2() {

        System.out.println("Размеры коробки: длина = " + length + ", ширина = " + width + ", высота = " + heigth);
        System.out.println("Цвет коробки - " + color);

        if (openclose) System.out.println("Коробка открыта");
        else System.out.println("Коробка закрыта");
        System.out.println((listSubjects == null || listSubjects.size() <= 0) ? "Коробка пуста" : "В коробке находятся следующие предметы " + listSubjects);
    }

    public void putSubject(String subject) {

        if (!openclose) {
            System.out.println("Положить предмет в коробку нельзя. Коробка закрыта");
            return;
        }
        if (this.subject == null) {
            this.subject = new String[1];
            this.subject[0] = subject;
        } else {
            int n = this.subject.length;
            this.subject = Arrays.copyOf(this.subject, this.subject.length + 1);
            this.subject[n] = subject;
        }
        System.out.println("В коробку положили предмет " + subject);
    }

    public void addSubject(String subject) {

        if (!openclose) {
            System.out.println("Положить предмет в коробку нельзя. Коробка закрыта");
            return;
        }
        if (listSubjects == null) {
            listSubjects = new ArrayList();
            listSubjects.add(subject);
        } else {
            listSubjects.add(subject);
        }
        System.out.println("В коробку положили предмет " + subject);
    }

    public void deleteSubject(String subject) {

        if (!openclose) {
            System.out.println("Убрать предмет " + subject + " или проверить его наличие в коробке нельзя. Коробка закрыта");
            return;
        }

        boolean subjectExist = false;
        if (this.subject != null && this.subject.length > 0) {
            for (int i = 0; i < this.subject.length; i++) {
                if (this.subject[i].equalsIgnoreCase(subject)) {
                    this.subject[i] = null;
                    subjectExist = true;
                    break;
                }
            }
        } else {
            System.out.println("Коробка открыта и пуста");
            return;
        }
        if (!subjectExist) {
            System.out.println("Коробка открыта, но предмета " + subject + " нет в коробке");
            return;
        }

        if (this.subject.length == 1) {
            this.subject = null;
            System.out.println("Коробка открыта, предмет " + subject + " убран из коробки");
            return;
        }

        if (this.subject.length > 1) {
            String[] copySubject = new String[this.subject.length - 1];
            int cnt = 0;
            for (int i = 0; i < this.subject.length; i++) {
                if (this.subject[i] != null) {
                    copySubject[cnt] = this.subject[i];
                    cnt++;
                }
            }
            System.out.println("Коробка открыта, предмет " + subject + " убран из коробки");
            this.subject = Arrays.copyOf(copySubject, copySubject.length);
        }
    }

    public void delSubject(String subject) {

        if (!openclose) {
            System.out.println("Убрать предмет " + subject + " или проверить его наличие в коробке нельзя. Коробка закрыта");
            return;
        }

        if (listSubjects != null && listSubjects.size() > 0) {
            if (listSubjects.remove(subject))
                System.out.println("Коробка открыта, предмет " + subject + " убран из коробки");
            else
                System.out.println("Коробка открыта, но предмета " + subject + " нет в коробке");
        } else System.out.println("Коробка открыта и пуста");
    }

    public void removeSubject(String subject) {
        if (!openclose) {
            System.out.println("Убрать предмет " + subject + " или проверить его наличие в коробке нельзя. Коробка закрыта");
            return;
        }
        if (ArrayUtils.contains(this.subject, subject) && this.subject.length > 0) {
            if (this.subject.length > 1) {
                this.subject = ArrayUtils.removeElement(this.subject, subject);
            } else this.subject = null;
            System.out.println("Коробка открыта, предмет " + subject + " убран из коробки");
        } else System.out.println("Коробка открыта, но предмета " + subject + " нет в коробке");
    }*/
}