import controller.Controller;
import model.CandyBox;
import utils.modelHelper.CandyBoxCollector;
import view.View;

/**
 * Created by Denis on 02.04.2018.
 */
public class Main {

    public static void main(String[] args) {
        CandyBox candyBox = new CandyBox();
        View view = new View();
        Controller controller = new Controller(candyBox, view);
        controller.handleRequest();
    }
}
