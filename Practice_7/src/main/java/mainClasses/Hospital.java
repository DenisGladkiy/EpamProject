package mainClasses;

import mainClasses.controller.Controller;
import mainClasses.model.Storage;
import utils.StorageFiller;

/**
 * Created by Denis on 01.03.2018.
 */
public class Hospital {

    public static void main(String[] args) {
        initialize();
    }

    private static void initialize(){
        Storage storage = new Storage();
        StorageFiller filler = new StorageFiller(storage);
        filler.fillStorage();
        Controller controller = new Controller(storage);
        controller.showMenu();
    }
}
