package controller;

import model.CandyBox;
import utils.SweetsSugarComparator;
import utils.modelHelper.CandyBoxCollector;
import utils.viewHelper.ConsoleReader;
import utils.viewHelper.Menu;
import view.View;

/**
 * Created by Denis on 01.04.2018.
 */
public class Controller {
    View view;
    CandyBox candyBox;
    ConsoleReader reader;
    CandyBoxCollector collector;

    public Controller(CandyBox candyBox, View view){
        this.view = view;
        this.candyBox = candyBox;
        reader = new ConsoleReader();
        collector = new CandyBoxCollector(candyBox);
    }

    public void handleRequest(){
        String line;
        view.showMenu();
        do{
            line = reader.readLine();
            if(line.equals("1")){
                view.reply(Menu.ASK_WEIGHT);
                int weight = reader.readInt();
                collector.collectCandyBox(weight);
                view.reply(Menu.SUCCESS);
            }
            if(line.equals("2")){
                view.reply(candyBox.getSweets().toString());
                view.reply(String.valueOf(candyBox.getWeight()));
            }
            if(line.equals("3")){
                candyBox.sortSweets(new SweetsSugarComparator());
                view.reply(Menu.SUCCESS);
            }
            if(line.equals("4")){
                view.reply(Menu.ASK_SUGAR);
                line = reader.readLine();
                String[] sugar = line.split("-");
                view.reply(candyBox.selectBySugar(Integer.parseInt(sugar[0]), Integer.parseInt(sugar[1])).toString());
            }
        }
        while(!line.equalsIgnoreCase("exit"));
    }
}
