package mainClasses.controller;

import mainClasses.view.UserInterface;
import mainClasses.model.Storage;

/**
 * Created by Denis on 01.03.2018.
 */
public class Controller {

    private UserInterface userInterface;
    private Storage storage;


    public Controller(Storage storage){
        this.storage = storage;
        userInterface = new UserInterface(this);
    }

    public String handle(String request){
        switch (request){
            case "0" : {
                return storage.showAllPatients();
            }
            case "1" : {
                String illness = userInterface.askIllness();
                return storage.selectByIllness(illness);
            }
            case "2" : {
                int[] numbers = userInterface.askNumbers();
                return storage.selectByNumber(numbers);
            }
            case "3" : {
                return storage.sortArray();
            }
            default:{
                System.out.println("Неизвестный запрос");
            }
        }
        return "";
    }

    public void showMenu(){
        userInterface.makeMenu();
    }
}
