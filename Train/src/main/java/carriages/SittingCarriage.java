package carriages;

/**
 * Created by Denis on 15.03.2018.
 */
public class SittingCarriage extends PassCarriage {

    public SittingCarriage(int carriageNumber, int seatsNumber, int baggageNumber, int comfortClass) {
        super(carriageNumber, seatsNumber, baggageNumber, comfortClass);
    }

    public void showTv(){
        System.out.println("Television");
    }
}
