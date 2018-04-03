package model.entity;

/**
 * Created by Denis on 01.04.2018.
 */
public class ChocolateCandy extends Sweets {

    public ChocolateCandy(int sugar, int weight, int price) {
        super(sugar, weight, price);
    }

    public double calculateCalories() {
        return 0;
    }

    @Override
    public String toString(){
        return "\nChocolateCandy " + " " + String.valueOf(sugar) + " " + String.valueOf(weight)+ " " + String.valueOf(price);
    }
}
