package view;

import java.util.Scanner;

/**
 * Created by Denis on 23.03.2018.
 */
public class ConsoleReader {
    private Scanner scanner;

    public ConsoleReader(){
        scanner = new Scanner(System.in);
    }

    public String readString(){
        return scanner.next();
    }

    public String readLine(){
        return scanner.nextLine();
    }
}
