import controller.Controller;
import model.Model;

/**
 * Created by Denis on 23.03.2018.
 */
public class Starter {
    public static void main(String[] args) {
        Model model = new Model();
        Controller controller = new Controller(model);
        controller.hello();
        controller.readLine();
    }
}
