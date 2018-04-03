package utils.modelHelper;

import model.CandyBox;
import model.entity.Sweets;
import utils.SweetsEnum;

import java.util.ArrayList;
import java.util.List;

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

    public void collectCandyBox(){
        candyBox.addSweetsCollection(produceSweets(20, SweetsEnum.CaramelCandy));
        candyBox.addSweetsCollection(produceSweets(20, SweetsEnum.ChocolateCandy));
        candyBox.addSweetsCollection(produceSweets(20, SweetsEnum.Marmalade));
    }

    private List<Sweets> produceSweets(int number, SweetsEnum sweets){
        List<Sweets> sweetsCollection = new ArrayList<Sweets>();
        for(int i = number; i > 0; i--){
            sweetsCollection.add(sweetsFactory.makeSweets(sweets));
        }
        return sweetsCollection;
    }
}
