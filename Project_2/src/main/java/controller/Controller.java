package controller;

import searchEngine.SearchEngine;
import view.View;

/**
 * Created by Denis on 15.04.2018.
 */
public class Controller {
    private View view;
    private SearchEngine searchEngine;

    public  Controller(View view){
        this.view = view;
    }

    public void handle(){
        String filePath = view.askBook();
        searchEngine = new SearchEngine(filePath);
        String search = view.askSearch();
        while(!search.equals("exit")) {
            view.showResult(searchEngine.doSearch(search));
            search = view.askSearch();
        }
    }
}
