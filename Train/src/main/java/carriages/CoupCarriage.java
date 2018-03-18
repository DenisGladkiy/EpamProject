package carriages;

/**
 * Created by Denis on 15.03.2018.
 */
public class CoupCarriage extends PassCarriage{

    public CoupCarriage(int carriageNumber, int seatsNumber, int baggageNumber, int comfortClass) {
        super(carriageNumber, seatsNumber, baggageNumber, comfortClass);
    }

    public void tea(){
        System.out.println("Tea");
    }
}
