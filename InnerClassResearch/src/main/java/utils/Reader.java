package utils;

import java.util.Scanner;

/**
 * Created by Denis on 28.02.2018.
 */
public class Reader {

    private Scanner scanner;

    public Reader(){
        scanner = new Scanner(System.in);
    }


    public int readInt(){
        return scanner.nextInt();
    }

    public String readString(){
        return scanner.next();
    }
}
