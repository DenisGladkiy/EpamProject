package model.entity;

/**
 * Created by Denis on 01.04.2018.
 */
public class CaramelCandy extends Sweets{

    public CaramelCandy(double sugar, double weight, double price) {
        super(sugar, weight, price);
    }

    public double calculateCalories() {
        return 0;
    }
}
