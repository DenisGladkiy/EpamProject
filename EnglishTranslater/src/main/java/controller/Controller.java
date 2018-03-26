package controller;

import translater.Translater;
import utils.ConsoleReader;
import utils.ConsoleWriter;
import utils.DbHandler;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Denis on 25.03.2018.
 */
public class Controller {
    private Translater translater;
    private ConsoleReader reader;
    private ConsoleWriter writer;
    private DbHandler handler;

    public Controller(Translater translater, DbHandler handler){
        this.translater = translater;
        this.handler = handler;
        reader = new ConsoleReader();
        writer = new ConsoleWriter();
    }

    public void work(){
        String request;
        String addString;
        Pattern add = Pattern.compile("^(add:)(\\D+)");
        Matcher addMatcher;
        while(true){
            request = reader.readLine();
            if(request.equalsIgnoreCase("exit")){
                return;
            }
            addMatcher = add.matcher(request);
            if(addMatcher.find()){
                addString = addMatcher.group(2);
                handler.addPair(addString);
                writer.writeConsole("В словарь добавлены - " + addString);
                continue;
            }
            writer.writeConsole(translater.translate(request));
        }
    }
}
