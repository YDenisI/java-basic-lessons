package ru.gpncr.java.basic.lessons;

public class Plate {
    private int maxAmountFood;
    private int currentAmountFood;

    public Plate(int maxAmountFood) {
        this.maxAmountFood = maxAmountFood;
        this.currentAmountFood = maxAmountFood;
    }

    public void addFood(int food) {

        if (currentAmountFood == maxAmountFood) {
            System.out.println("Добавить на тарелку " + food + " у.е. еды нельзя. Тарелка полная");
            return;
        }
        if ((currentAmountFood + food) <= maxAmountFood) {
            System.out.println("На тарелку добавили " + food + " у.е. еды");
            currentAmountFood += food;
        } else {
            int partFood = maxAmountFood - currentAmountFood;
            currentAmountFood += partFood;
            System.out.println("На тарелку необходимо положить " + food + " у.е., но было добавлено только " + partFood + " у.е. Тарелка полная");
        }
    }

    //вводим дополнительную переменную eat для определения действия "Удалить еду с тарелки" или "Кот кушает"
    // Пример: если на тарелке лежит условно 3 е. еды, а просят убрать 6 е., то с тарелки можно убрать всё
    // Если такое подход неприемлем, то удаляем строки 38-41 кода и требуется раскомментировать строку 36 кода
    public boolean reduceFood(int food, boolean eat) {

        if ((currentAmountFood - food) >= 0) {
            currentAmountFood -= food;
            return true;
        } //else return false;

        if (!eat) {
            currentAmountFood = 0;
            return true;
        } else return false;
    }

    public String getStatePlate() {

        if (maxAmountFood == currentAmountFood)
            return "Тарелка полностью заполнена едой. Количество еды на тарелке: " + currentAmountFood;

        return currentAmountFood != 0 ? "Количество еды на тарелке: " + currentAmountFood + " у.е." : "Тарелка пустая";
    }

    public int getMaxAmountFood() {
        return maxAmountFood;
    }

    public int getCurrentAmountFood() {
        return currentAmountFood;
    }
}
