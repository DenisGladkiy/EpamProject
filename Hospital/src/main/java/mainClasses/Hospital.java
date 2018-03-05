package mainClasses;

import utils.Storage;
import utils.StorageFiller;

/**
 * Created by Denis on 01.03.2018.
 */
public class Hospital {

    public static void main(String[] args) {
        initialize();
        showMenu();
    }

    private static void showMenu(){
        UserInterface userInterface = new UserInterface();
        userInterface.makeMenu();
    }

    private static void initialize(){
        Storage storage = new Storage();
        StorageFiller filler = new StorageFiller(storage);
        filler.fillStorage();
    }

}
