package translater;

import database.WordsDataBase;

/**
 * Created by Denis on 25.03.2018.
 */
public class Translater {
    WordsDataBase db;

    public Translater(WordsDataBase db){
        this.db = db;
    }

    public String translate(String english){
        return db.getTranslation(english);
    }
}
