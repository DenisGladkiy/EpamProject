package controller;

import model.CandyBox;
import model.entity.Sweets;
import utils.SweetsSugarComparator;
import utils.modelHelper.CandyBoxCollector;
import utils.viewHelper.ConsoleReader;
import utils.viewHelper.Menu;
import view.View;

import java.util.Comparator;

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
        view.showMenu();
        String line;
        while(!(line = reader.readLine()).equalsIgnoreCase("exit")){
            if(line.equals("")) continue;
            if(line.equals("1")){
                handleFilling();
            }else if(line.equals("2")){
                handleShowList();
            }else if(line.equals("3")){
                handleSort(new SweetsSugarComparator());
            }else if(line.equals("4")){
                handleSelection();
            }else if(!line.equalsIgnoreCase("exit")){
                view.reply(Menu.UNKNOWN);
            }
            view.showMenu();
        }
    }

    private void handleFilling(){
        view.reply(Menu.ASK_WEIGHT);
        int weight = reader.readInt();
        if(weight > 0){
            collector.collectCandyBox(weight);
            view.reply(Menu.SUCCESS);
        }else{
            view.reply(Menu.INCORRECT);
        }
    }

    private void handleShowList(){
        view.reply(candyBox.getSweets().toString());
        view.reply(String.valueOf(candyBox.getWeight()));
    }

    private void handleSort(Comparator<Sweets> comparator){
        candyBox.sortSweets(comparator);
        view.reply(Menu.SUCCESS);
    }

    private void handleSelection(){
        view.reply(Menu.ASK_SUGAR);
        int[] range = reader.readRange();
        if(range[1] != 0) {
            view.reply(candyBox.selectBySugar(range[0], range[1]).toString());
        }else{
            view.reply(Menu.WRONG_RANGE);
        }
    }
}
