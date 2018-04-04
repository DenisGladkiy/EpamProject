package model.entity;

/**
 * Created by Denis on 01.04.2018.
 */
public abstract class Sweets {
    private int sugar;
    private int weight;
    private int price;

    public Sweets(int sugar, int weight, int price) {
        this.sugar = sugar;
        this.weight = weight;
        this.price = price;
    }

    public int getSugar(){
        return sugar;
    }

    public int getWeight(){
        return weight;
    }

    public int getPrice(){
        return price;
    }

    public abstract double calculateCalories();

}
