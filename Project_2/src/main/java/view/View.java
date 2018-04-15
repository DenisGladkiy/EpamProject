package view;

import java.util.Scanner;

/**
 * Created by Denis on 12.04.2018.
 */
public class View {
    Scanner scanner;

    public View(){
        //System.out.println("Добро пожаловать в программу поиска текста");
        System.out.println(Menu.HELLO);
        scanner = new Scanner(System.in);
    }

    public String askBook(){
        System.out.println(Menu.FILEPATH);
        return scanner.nextLine();
    }

    public String askSearch(){
        System.out.println(Menu.TEXT);
        return scanner.nextLine();
    }
}
