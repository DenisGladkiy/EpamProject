package carriages;

/**
 * Created by Denis on 15.03.2018.
 */
public class SvCarriage extends PassCarriage {

    public SvCarriage(int carriageNumber, int seatsNumber, int baggageNumber, int comfortClass) {
        super(carriageNumber, seatsNumber, baggageNumber, comfortClass);
    }

    public void breakfast(){
        System.out.println("Breakfast");
    }
}
