package Reflection.createInstance;

/**
 * Created by Denis on 08.04.2018.
 */
public class ArithmeticOperation {
    private double value;

    public ArithmeticOperation(){}

    public ArithmeticOperation(double value){
        this.value = value;
    }

    public double incrementValue(){
        return ++value;
    }

    public double decrementValue(){
        return --value;
    }

    public double oppositeValue(){
        return -value;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "value=" + value;
    }
}
