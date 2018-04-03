package utils.modelHelper;

import model.entity.CaramelCandy;
import model.entity.ChocolateCandy;
import model.entity.Marmalade;
import model.entity.Sweets;
import utils.SweetsEnum;

/**
 * Created by Denis on 01.04.2018.
 */
public class SweetsFactory {

    public Sweets makeSweets(SweetsEnum sweets){
        switch (sweets){
            case CaramelCandy:
                return makeCaramelCandy();
            case ChocolateCandy:
                return makeChocolateCandy();
            case Marmalade:
                return makeMarmalade();
            default:
                return null;
        }
    }

    private Sweets makeCaramelCandy(){
        int sugar = 15 + (int) (Math.random() * 5);
        int weight = 20 + (int) (Math.random() * 5);
        int price = 5 + (int) (Math.random() * 5);
        return new CaramelCandy(sugar, weight, price);
    }

    private Sweets makeChocolateCandy(){
        int sugar = 7 + (int) (Math.random() * 5);
        int weight = 15 + (int) (Math.random() * 5);
        int price = 10 + (int) (Math.random() * 5);
        return new ChocolateCandy(sugar, weight, price);
    }

    private Sweets makeMarmalade(){
        int sugar = 9 + (int) (Math.random() * 5);
        int weight = 20 + (int) (Math.random() * 5);
        int price = 7 + (int) (Math.random() * 5);
        return new Marmalade(sugar, weight, price);
    }
}
