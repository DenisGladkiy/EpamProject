package carriages;

/**
 * Created by Denis on 17.03.2018.
 */
public class PassCarriage extends Carriage implements Comparable<PassCarriage>{

    private int seatsNumber;
    private int baggageNumber;
    private int comfortClass;

    public PassCarriage(int carriageNumber, int seatsNumber, int baggageNumber, int comfortClass) {
        super(carriageNumber);
        this.seatsNumber = seatsNumber;
        this.baggageNumber = baggageNumber;
        this.comfortClass = comfortClass;
    }

    public void run(){
        System.out.println("Carriage is running");
    }

    public int getSeatsNumber() {
        return seatsNumber;
    }

    public void setSeatsNumber(int seatsNumber) {
        this.seatsNumber = seatsNumber;
    }

    public int getBaggageNumber() {
        return baggageNumber;
    }

    public void setBaggageNumber(int baggageNumber) {
        this.baggageNumber = baggageNumber;
    }

    public int getComfortClass() {
        return comfortClass;
    }

    public void setComfortClass(int comfortClass) {
        this.comfortClass = comfortClass;
    }

    @Override
    public String toString() {
        return "\nPassCarriage{" +
                "carriageNumber=" + super.getCarriageNumber() +
                ", seatsNumber=" + seatsNumber +
                ", baggageNumber=" + baggageNumber +
                ", comfortClass=" + comfortClass +
                '}';
    }

    public int compareTo(PassCarriage pc) {
        return this.comfortClass - pc.getComfortClass();
    }
}
