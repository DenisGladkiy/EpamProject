package database;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Denis on 25.03.2018.
 */
public class WordsDataBase {
    Map<String, String> words;

    public WordsDataBase(){
        words = new HashMap<String, String>();
    }

    public void addPair(String english, String russian){
        words.put(english, russian);
    }

    public String getTranslation(String english){
        return words.get(english);
    }
}
