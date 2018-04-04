package model;

import model.entity.Sweets;

import java.util.*;

/**
 * Created by Denis on 01.04.2018.
 * Класс описывает коробку конфет - детский подарок.
 * В классе содержется список сладостей и методы для
 * сортировки и наполнения подарка.
 */
public class CandyBox {
    List<Sweets> sweetsBox;
    int weight;

    public CandyBox(){
        sweetsBox = new ArrayList<>();
    }

    public void addSweets(Sweets sweets){
        sweetsBox.add(sweets);
        weight += sweets.getSugar();
    }

    public void addSweetsCollection(List<Sweets> addSweets){
        sweetsBox.addAll(addSweets);
    }

    public List<Sweets> getSweets(){
        return sweetsBox;
    }

    public int getWeight(){
        return weight;
    }

    public void sortSweets(Comparator<Sweets> comparator){
        Collections.sort(sweetsBox, comparator);
    }

    public List<Sweets> selectBySugar(int from, int to){
        List<Sweets> requestedSweets = new ArrayList<>();
        int sugar;
        for(Sweets sweets : sweetsBox){
            sugar = sweets.getSugar();
            if(sugar >= from && sugar <= to){
                requestedSweets.add(sweets);
            }
        }
        return requestedSweets;
    }

    public double calculateTotalCalories(){
        return 0;
    }

    public double calculateTotalPrice(){
        return 0;
    }
}
