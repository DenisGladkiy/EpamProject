package view;

import Entity.Sentence;

import java.util.List;
import java.util.Scanner;

/**
 * Created by Denis on 12.04.2018.
 */
public class View {
    private Scanner scanner;

    public View(){
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

    public void showResult(List<Sentence> sentences){
        sentences.forEach(sentence -> System.out.println(sentence));
    }

    public void reply(String reply){
        System.out.println(reply);
    }
}
