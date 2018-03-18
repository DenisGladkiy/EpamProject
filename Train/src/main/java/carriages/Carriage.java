package carriages;

/**
 * Created by Denis on 15.03.2018.
 */
public abstract class Carriage {

    private int carriageNumber;

    public Carriage(int carriageNumber) {
        this.carriageNumber = carriageNumber;
    }

    public int getCarriageNumber(){
        return carriageNumber;
    }

    public abstract void run();
}
