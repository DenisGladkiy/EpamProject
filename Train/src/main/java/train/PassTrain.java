package train;

import carriages.PassCarriage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Denis on 15.03.2018.
 */
public class PassTrain <T extends PassCarriage>{

    List<T> train;

    public PassTrain(){
        train = new ArrayList();
    }

    public PassTrain(List train) {
        this.train = train;
    }

    public void addCarriage(T carriage){
        train.add(carriage);
    }

    public void shuffle(){
        Collections.shuffle(train);
    }

    public void sortByComfort(){
        Collections.sort(train);
    }

    public int calcTotalPassengers(){
        int totalPassengers = 0;
        for(T carr : train){
            totalPassengers += carr.getSeatsNumber();
        }
        return totalPassengers;
    }

    public int calcTotalBaggage(){
        int totalBaggage = 0;
        for(T carr : train){
            totalBaggage += carr.getBaggageNumber();
        }
        return totalBaggage;
    }

    public List getCarriagesByPassNumber(int numberFrom, int numberTo){
        List carriages = new ArrayList();
        for(T carr : train){
            if((carr.getSeatsNumber() > numberFrom) && (carr.getSeatsNumber() < numberTo)){
                carriages.add(carr);
            }
        }
        return carriages;
    }

    @Override
    public String toString() {
        return "PassTrain{" +
                "train=" + train +
                '}';
    }
}
