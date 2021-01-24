package ru.lesson6.brute;

import java.util.Random;

public class Bowl {
    Random random = new Random();

    private int quantity;

    public int getQuantity() {
        return quantity;
    }

    public void muchEat(int much) {
        this.quantity = this.quantity - much;
        System.out.println("Корма в тарелке осталось " + this.quantity);
    }

    public void fillFeed(){
        this.quantity = this.quantity + random.nextInt(50);
        System.out.println("Насыпаем корм в тарелку.\nКорма в тарелке " + this.quantity);
    }
}
