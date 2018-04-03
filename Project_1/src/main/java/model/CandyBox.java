package model;

import model.entity.Sweets;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Denis on 01.04.2018.
 * Класс описывает коробку конфет - детский подарок.
 * В классе содержется список сладостей и методы для
 * сортировки и наполнения подарка.
 */
public class CandyBox {
    List<Sweets> sweets;

    public CandyBox(){
        sweets = new ArrayList<Sweets>();
    }

    public List<Sweets> collectBox(double weight){
        return null;
    }

    public List<Sweets> selectBySugar(double from, double to){
        return null;
    }

    public double calculateTotalCalories(){
        return 0;
    }

    public double calculateTotalPrice(){
        return 0;
    }

    public void addSweetsCollection(List<Sweets> addSweets){
        sweets.addAll(addSweets);
    }

    public List<Sweets> getSweets(){
        return sweets;
    }

}