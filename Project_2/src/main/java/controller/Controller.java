package controller;

import Entity.Sentence;
import org.apache.log4j.Logger;
import searchEngine.SearchEngine;
import view.Menu;
import view.View;

import java.io.File;
import java.util.List;

/**
 * Created by Denis on 15.04.2018.
 */
public class Controller {
    static Logger logger = Logger.getLogger(Controller.class);
    private View view;
    private SearchEngine searchEngine;

    public  Controller(View view){
        this.view = view;
    }

    public void handle(){
        String filePath = view.askBook();
        while (!isValidPath(filePath)){
            filePath = view.askBook();
        }
        searchEngine = new SearchEngine(filePath);
        String search = view.askSearch();
        while(!search.equals("exit")) {
            List<Sentence> sentences = searchEngine.doSearch(search);
            if(sentences == null || sentences.size() == 0) {
                view.reply(Menu.NO_RESULT);
            }else view.showResult(sentences);
            search = view.askSearch();
        }
    }

    private boolean isValidPath(String filepath){
        if(!filepath.endsWith("txt")){
            logger.debug("Not txt");
            return false;
        }
        File file = new File(filepath);
        if(file.exists() && !file.isDirectory()){
            return true;
        }
        logger.debug("file does not exist");
        return false;
    }
}
