package model.entity;

/**
 * Created by Denis on 01.04.2018.
 */
public abstract class Sweets {
    private double sugar;
    private double weight;
    private double price;

    public Sweets(double sugar, double weight, double price) {
        this.sugar = sugar;
        this.weight = weight;
        this.price = price;
    }

    public abstract double calculateCalories();
}
