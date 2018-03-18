package carriages;

/**
 * Created by Denis on 15.03.2018.
 */
public class BaggageCarriage extends PassCarriage {

    public BaggageCarriage(int carriageNumber, int seatsNumber, int baggageNumber, int comfortClass) {
        super(carriageNumber, seatsNumber, baggageNumber, comfortClass);
    }

    public void loadBaggage(){
        System.out.println("Baggage");
    }
}
