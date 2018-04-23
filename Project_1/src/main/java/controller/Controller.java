package controller;

import model.CandyBox;
import model.entity.Sweets;
import utils.SweetsSugarComparator;
import utils.modelHelper.CandyBoxCollector;
import utils.viewHelper.ConsoleReader;
import utils.viewHelper.Menu;
import mvc.view.View;

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
        while((line = reader.readLine()) != null){
            switch (line){
                case "": continue;
                case "1":
                    handleFilling();
                    break;
                case "2":
                    handleShowList();
                    break;
                case "3":
                    handleSort(new SweetsSugarComparator());
                    break;
                case "4":
                    handleSelection();
                    break;
                case "exit":
                    return;
                default:
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
