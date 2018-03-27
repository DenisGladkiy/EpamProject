/**
 * Created by Denis on 27.03.2018.
 */
public class Main{

    public static void main(String[] args) {
        ListAndSet las = new ListAndSet();
        Controller controller = new Controller(las);
        controller.work();
    }
}
