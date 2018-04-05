package mainClasses.view;

import mainClasses.controller.Controller;
import utils.Reader;

import java.io.IOException;

/**
 * Created by Denis on 01.03.2018.
 */
public class UserInterface {
    private Reader reader;
    private Controller controller;

    public UserInterface(Controller controller){
        this.controller = controller;
    }

    public void makeMenu(){
        showAllOptions();
        receiveRequest();
    }

    private void receiveRequest() {
        reader = new Reader();
        String request = reader.readString();
        while(!request.equals("exit")) {
            reply(handleRequest(request));
            showAllOptions();
            request = reader.readString();
        }
    }

    private String handleRequest(String request) {
        try {
            return controller.handle(request);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Menu.MISTAKE;
    }

    public String askIllness(){
        System.out.println(Menu.ASK_ILLNESS);
        return reader.readString();
    }

    public String askFilePath(){
        System.out.println(Menu.ASK_FILE);
        return reader.readString();
    }

    public int[] askNumbers(){
        System.out.println(Menu.ASK_NUMBERS);
        String[] stringNumbers = reader.readString().split("-");
        int[] numbers = new int[2];
        if(stringNumbers.length == 2){
            int num1 = Integer.parseInt(stringNumbers[0]);
            int num2 = Integer.parseInt(stringNumbers[1]);
            if(num1 < num2) {
                numbers[0] = num1;
                numbers[1] = num2;
            }else {
                numbers[0] = -1;
            }
        }
        return numbers;
    }

    private void reply(String rep){
        System.out.println(rep);
    }

    private void showAllOptions(){
        System.out.println("");
        System.out.println(Menu.ZERO);
        System.out.println(Menu.ONE);
        System.out.println(Menu.TWO);
        System.out.println(Menu.THREE);
        System.out.println(Menu.FOUR);
        System.out.println(Menu.FIVE);
        System.out.println(Menu.EXIT);
    }
}
