package utils;

import carriages.PassCarriage;
import train.PassTrain;

/**
 * Created by Denis on 15.03.2018.
 */
public class Depot {

    public PassTrain makeTrain(){
        CarriageFactory carriageFactory = new CarriageFactory();
        PassTrain train = new PassTrain();
        train.addCarriage((PassCarriage) carriageFactory.getCarriage(CarriageType.Baggage));
        for(int i = 0; i < 6; i++){
            train.addCarriage((PassCarriage) carriageFactory.getCarriage(CarriageType.Sv));
        }
        for(int i = 0; i < 10; i++){
            train.addCarriage((PassCarriage) carriageFactory.getCarriage(CarriageType.Coup));
        }
        for(int i = 0; i < 5; i++){
            train.addCarriage((PassCarriage) carriageFactory.getCarriage(CarriageType.Sitting));
        }
        //train.addCarriage((PassCarriage) carriageFactory.getCarriage(CarriageType.Cargo));
        train.shuffle();
        return train;
    }
}
