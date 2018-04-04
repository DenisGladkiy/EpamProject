package utils.viewHelper;

import java.util.Scanner;

/**
 * Created by Denis on 01.04.2018.
 */
public class ConsoleReader {
    private Scanner scanner;

    public ConsoleReader(){
        scanner = new Scanner(System.in);
    }

    public String readString(){
        return scanner.next();
    }

    public int readInt(){
        return scanner.nextInt();
    }

    public String readLine(){
        return scanner.nextLine();
    }
}
