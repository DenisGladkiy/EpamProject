package simpleThread;

/**
 * Created by Denis on 17.04.2018.
 */
public class SimpleThread {

    public static void main(String[] args) {
        Runnable simpleRunnable = () -> {
            for(int i = 10; i > 0 ; i--) {
                System.out.println(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Boooom!");
        };
        new Thread(simpleRunnable).start();
    }
}
