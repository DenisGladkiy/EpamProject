import controller.Controller;
import model.CandyBox;
import utils.modelHelper.CandyBoxCollector;

/**
 * Created by Denis on 02.04.2018.
 */
public class Main {

    public static void main(String[] args) {
        CandyBox candyBox = new CandyBox();
        CandyBoxCollector collector = new CandyBoxCollector(candyBox);
        collector.collectCandyBox();
        Controller controller = new Controller(candyBox);
        controller.handleRequest();
    }
}
