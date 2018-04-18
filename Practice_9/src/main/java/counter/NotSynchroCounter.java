package counter;

/**
 * Created by Denis on 18.04.2018.
 */
public class NotSynchroCounter {
    private static int value = 0;

    public static void main(String[] args) {
        startCounter();
    }

    private static void startCounter() {
        Thread counter = new Thread(() -> {
            while (value < 1000000){
                value++;
            }
        });

        Thread printer = new Thread(() -> {
            while(value < 1000000){
                System.out.println(value);
            }
        });

        counter.start();
        printer.start();
    }
}
