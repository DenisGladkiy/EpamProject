package utils;

import database.WordsDataBase;

import java.io.*;

/**
 * Created by Denis on 25.03.2018.
 */
public class DbHandler {
    private static final String FILE = "EnglishTranslater/src/words.txt";
    private WordsDataBase db;

    public DbHandler(WordsDataBase db){
        this.db = db;
    }

    public void fillDb(){
        File myFile = new File(FILE);
        try {
            FileReader fileReader = new FileReader(myFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            while (null != line){
                addPair(line);
                line = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addPair(String pair){
        String[] lineArr = pair.split("-");
        db.addPair(lineArr[0].trim(), lineArr[1].trim());
    }
}
