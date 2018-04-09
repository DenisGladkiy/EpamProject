package Reflection.createInstance;

/**
 * Created by Denis on 08.04.2018.
 */
public class Starter {

    public static void main(String[] args) {
        ArithmeticOperation operation = new ArithmeticOperation(3.4325);
        System.out.println("Normal instance " + operation);
        InstanceCreator ic = new InstanceCreator();
        ArithmeticOperation reflectionOperation = ic.createInstance();
        System.out.println("Reflection instance " + reflectionOperation);
        double refValue = ic.readPrivate(reflectionOperation);
        System.out.println("Read private field = " + refValue);
        //ic.setPrivate(reflectionOperation, 12.5);
        ic.setValue(reflectionOperation, 15.5);
        System.out.println("Reflection instance after invoke method = " + reflectionOperation);
    }
}
