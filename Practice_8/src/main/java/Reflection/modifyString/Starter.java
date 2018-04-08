package Reflection.modifyString;

import org.apache.log4j.Logger;

import java.util.Scanner;

/**
 * Created by Denis on 08.04.2018.
 */
public class Starter {
    private VarContainer container;
    private Scanner scanner = new Scanner(System.in);
    static Logger logger = Logger.getLogger(Starter.class);

    public static void main(String[] args) {
        Starter starter = new Starter();
        starter.showOptions();
        starter.initVariable();
        logger.debug("Before = " + starter.container.getVariable());
        starter.modify();
        logger.debug("After = " + starter.container.getVariable());
    }

    private void initVariable(){
        container = new VarContainer();
        int option = askOption();
        switch (option){
            case 1:
                container.setVariable();
                break;
            case 2:
                container.setVariable(askString());
                break;
        }
    }

    private int askOption(){
        return scanner.nextInt();
    }

    private String askString(){
        System.out.println("Введите слово");
        String string = scanner.next();
        return string;
    }

    private void showOptions(){
        System.out.println("1 - Программная инициализация");
        System.out.println("2 - Инициализация вводом с клавиатуры");
    }

    private void modify(){
        PrivateFieldModifier modifier = new PrivateFieldModifier(container);
        try {
            modifier.modifyPrivateField();
        } catch (NoSuchFieldException e) {
            logger.debug("No such field");
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            logger.debug("Illegal access");
            e.printStackTrace();
        }
    }
}
