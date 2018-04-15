import controller.Controller;
import fileReader.MyFileReader;
import searchEngine.SearchEngine;
import view.View;

import java.io.IOException;

/**
 * Created by Denis on 12.04.2018.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        View view = new View();
        Controller controller = new Controller(view);
        controller.handle();
    }
}
