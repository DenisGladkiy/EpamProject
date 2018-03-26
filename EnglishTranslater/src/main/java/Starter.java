import database.WordsDataBase;
import translater.Translater;
import utils.DbHandler;
import controller.Controller;

/**
 * Created by Denis on 25.03.2018.
 */
public class Starter {
    public static void main(String[] args) {
        WordsDataBase db = new WordsDataBase();
        DbHandler handler = new DbHandler(db);
        handler.fillDb();
        Controller controller = new Controller(new Translater(db), handler);
        controller.work();
    }
}
