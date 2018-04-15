package controller;

import searchEngine.SearchEngine;
import view.View;

import java.io.IOException;

/**
 * Created by Denis on 15.04.2018.
 */
public class Controller {
    View view;
    SearchEngine searchEngine;

    public  Controller(View view){
        this.view = view;;
    }

    public void handle(){
        String filePath = view.askBook();
        searchEngine = new SearchEngine(filePath);
        String search = view.askSearch();
        while(!search.equals("exit")) {
            searchEngine.search(search);
            search = view.askSearch();
        }
    }
}
