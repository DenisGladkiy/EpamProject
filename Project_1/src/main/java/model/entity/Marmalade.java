package model.entity;

/**
 * Created by Denis on 01.04.2018.
 */
public class Marmalade extends Sweets {

    public Marmalade(double sugar, double weight, double price) {
        super(sugar, weight, price);
    }

    public double calculateCalories() {
        return 0;
    }
}
