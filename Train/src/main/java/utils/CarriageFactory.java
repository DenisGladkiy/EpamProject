package utils;

import carriages.*;

/**
 * Created by Denis on 15.03.2018.
 */
public class CarriageFactory {
    private int carrNumber = 0;

    public Carriage getCarriage(CarriageType type){
        Carriage carr;
        switch (type){
            case Sv:
                carr = new SvCarriage(carrNumber++, 20, 5, 1);
                return carr;
            case Coup:
                carr = new CoupCarriage(carrNumber++, 40, 10, 2);
                return carr;
            case Sitting:
                carr = new SittingCarriage(carrNumber++, 60, 11, 3);
                return carr;
            case Baggage:
                carr = new BaggageCarriage(carrNumber++, 2, 100, 0);
                return carr;
            case Cargo:
                carr = new CargoCarriage(carrNumber++, 1000);
                return carr;
        }
        return null;
    }
}
