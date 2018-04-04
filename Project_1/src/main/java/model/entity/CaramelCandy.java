package model.entity;

/**
 * Created by Denis on 01.04.2018.
 */
public class CaramelCandy extends Sweets{

    public CaramelCandy(int sugar, int weight, int price) {
        super(sugar, weight, price);
    }

    public double calculateCalories() {
        return 0;
    }

    @Override
    public String toString(){
        return "\nCaramelCandy " + " " + String.valueOf(getSugar()) + " " +
                String.valueOf(getWeight())+ " " +
                String.valueOf(getPrice());
    }
}
