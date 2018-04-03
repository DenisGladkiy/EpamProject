package controller;

import model.CandyBox;
import utils.viewHelper.ConsoleReader;

/**
 * Created by Denis on 01.04.2018.
 */
public class Controller {
    CandyBox candyBox;
    ConsoleReader reader;

    public Controller(CandyBox candyBox){
        this.candyBox = candyBox;
        reader = new ConsoleReader();
    }

    public void handleRequest(){
        System.out.println("Для вывода списка конфет - 1");
        String line;
        do{
            line = reader.readLine();
            if(line.equals("1")){
                System.out.println(candyBox.getSweets());
            }
            if(line.equals("2")){

            }
        }
        while(!line.equalsIgnoreCase("exit"));
    }
}
