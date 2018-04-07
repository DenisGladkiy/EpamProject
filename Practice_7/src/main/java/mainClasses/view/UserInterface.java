package mainClasses.view;

import mainClasses.controller.Controller;
import org.apache.log4j.Logger;
import utils.Reader;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Denis on 01.03.2018.
 */
public class UserInterface {
    static Logger logger = Logger.getLogger(UserInterface.class);
    private String country;
    private Reader reader;
    private Controller controller;
    private ResourceBundle rb;
    private Locale locale;

    public UserInterface(Controller controller){
        this.controller = controller;
        reader = new Reader();
        locale = Locale.getDefault();
        rb = ResourceBundle.getBundle("text", locale);
    }

    public void makeMenu(){
        switchLanguage();
        showAllOptions();
        receiveRequest();
    }

    private void switchLanguage() {
        String language;
        switch (country){
            case "RU" :
                language = "ru";
                break;
            case "UA" :
                language = "uk";
                break;
            case "US" :
                language = "en";
                break;
            default:
                language = "en";
        }
        Locale locale = new Locale(language, country);
        rb = ResourceBundle.getBundle("text", locale);
    }

    private void receiveRequest() {
        String request = reader.readString();
        while(!request.equals("exit")) {
            logger.info("request = " + request);
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
        return rb.getString("MISTAKE");
    }

    public String askIllness(){
        System.out.println(rb.getString("ASK_ILLNESS"));
        return reader.readString();
    }

    public String askFilePath(){
        System.out.println(rb.getString("ASK_FILE"));
        return reader.readString();
    }

    public int[] askNumbers(){
        System.out.println(rb.getString("ASK_NUMBERS"));
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

    public String askLanguage(){
        System.out.println(rb.getString("LANGUAGE"));
        country = reader.readString();
        return country;
    }

    private void reply(String rep){
        System.out.println(rep);
    }

    private void showAllOptions(){
        System.out.println("");
        System.out.println(rb.getString("ZERO"));
        System.out.println(rb.getString("ONE"));
        System.out.println(rb.getString("TWO"));
        System.out.println(rb.getString("THREE"));
        System.out.println(rb.getString("FOUR"));
        System.out.println(rb.getString("FIVE"));
        System.out.println(rb.getString("SIX"));
        System.out.println(rb.getString("EXIT"));
    }
}
