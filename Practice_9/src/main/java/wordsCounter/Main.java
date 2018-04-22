package wordsCounter;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by Denis on 22.04.2018.
 */
public class Main {

    public static void main(String[] args) {
        doSearch();
    }

    private static void doSearch(){
        Scanner scan = new Scanner(System.in);
        File dir = initFile(scan);
        WordsCounter counter = initCounter(dir, scan);
        FutureTask<Integer> task = new FutureTask<Integer>(counter);
        new Thread(task).start();
        try {
            System.out.println(task.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    private static File initFile(Scanner scan){
        String dir;
        System.out.println("Enter dir path");
        dir = scan.nextLine();
        return new File(dir);
    }

    private static WordsCounter initCounter(File dir, Scanner scan){
        String letter;
        System.out.println("Enter a letter for search");
        letter = scan.next();
        return new WordsCounter(dir, letter);
    }
}
