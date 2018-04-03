package model.entity;

/**
 * Created by Denis on 01.04.2018.
 */
public abstract class Sweets {
    protected int sugar;
    protected int weight;
    protected int price;

    public Sweets(int sugar, int weight, int price) {
        this.sugar = sugar;
        this.weight = weight;
        this.price = price;
    }

    public abstract double calculateCalories();

}
