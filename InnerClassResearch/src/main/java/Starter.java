import controller.Controller;
import model.Shop;

/**
 * Created by Denis on 14.03.2018.
 */
public class Starter {

    public static void main(String[] args) {
        Shop shop = new Shop();
        Controller controller = new Controller(shop);
    }
}
