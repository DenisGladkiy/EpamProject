import train.PassTrain;
import utils.Depot;

/**
 * Created by Denis on 15.03.2018.
 */
public class Manager {

    public static void main(String[] args) {
        start();
    }

    private static void start(){
        Depot depot = new Depot();
        PassTrain train = depot.makeTrain();
        System.out.println(train);
        System.out.println("Sort train by comfort");
        train.sortByComfort();
        System.out.println(train);
        System.out.println("Total number of passengers = " + train.calcTotalPassengers());
        System.out.println("Total number of baggage = " + train.calcTotalBaggage());
        System.out.println("Select carriage with passengers from 30 to 50");
        System.out.println(train.getCarriagesByPassNumber(30, 50));
    }
}
