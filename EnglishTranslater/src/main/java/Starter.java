import database.WordsDataBase;
import translater.Translater;
import utils.DbHandler;
import controller.Controller;

/**
 * Created by Denis on 25.03.2018.
 */
public class Starter {
    private static Controller controller;

    public static void main(String[] args) {
        init();
        controller.work();
    }

    private static void init(){
        WordsDataBase db = new WordsDataBase();
        DbHandler handler = new DbHandler(db);
        handler.fillDb();
        controller = new Controller(new Translater(db), handler);
    }
}
