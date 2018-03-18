package carriages;

/**
 * Created by Denis on 15.03.2018.
 */
public class CargoCarriage extends Carriage {

    private int load;

    public CargoCarriage(int carriageNumber, int load){
        super(carriageNumber);
        this.load = load;
    }

    public void run() {
        System.out.println("Run Cargo");
    }
}
