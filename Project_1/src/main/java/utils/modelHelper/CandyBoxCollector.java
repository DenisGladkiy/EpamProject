package utils.modelHelper;

import model.CandyBox;
import model.entity.Sweets;
import utils.SweetsEnum;

import java.util.ArrayList;
import java.util.List;

import static utils.SweetsEnum.*;


/**
 * Created by Denis on 01.04.2018.
 */
public class CandyBoxCollector {
    CandyBox candyBox;
    SweetsFactory sweetsFactory;

    public CandyBoxCollector(CandyBox candyBox){
        this.candyBox = candyBox;
        sweetsFactory = new SweetsFactory();
    }

    public void collectCandyBox(int weight){
        SweetsEnum[] sweetType = {CaramelCandy, ChocolateCandy, Marmalade};
        int index = 0;
        while(candyBox.getWeight() < weight){
            candyBox.addSweets(sweetsFactory.makeSweets(sweetType[index]));
            if(++index > 2)index = 0;
        }
    }

    private List<Sweets> produceSweets(int number, SweetsEnum sweets){
        List<Sweets> sweetsCollection = new ArrayList<Sweets>();
        for(int i = number; i > 0; i--){
            sweetsCollection.add(sweetsFactory.makeSweets(sweets));
        }
        return sweetsCollection;
    }
}
