package counter;

/**
 * Created by Denis on 18.04.2018.
 */
public class SynchroCounter {
    private static Integer value = 0;
    private static boolean changed = false;

    public static void main(String[] args) {
        new SynchroCounter().startCounter();
    }

    private synchronized void increment(){
        if(!changed){
            value++;
            changed = true;
            notify();
        }else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private synchronized void print(){
        if(changed){
            System.out.println(value);
            changed = false;
            notify();
        }else{
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void startCounter() {

        Thread counter = new Thread(() -> {
            while (value < 1000000) {
               increment();
            }
        });

        Thread printer = new Thread(() -> {
            while (value < 1000000) {
                print();
            }
        });

        counter.start();
        printer.start();
    }
}
