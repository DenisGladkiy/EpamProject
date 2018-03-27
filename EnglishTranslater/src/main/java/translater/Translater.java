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
        String[] sentence = english.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        String translation;
        for(String s : sentence){
            translation = db.getTranslation(s);
            if(translation != null) {
                stringBuilder.append(db.getTranslation(s) + " ");
            }else{
                stringBuilder.append("??? ");
            }
        }
        return stringBuilder.toString();
    }
}
