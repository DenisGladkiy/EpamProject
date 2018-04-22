package wordsCounter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * Created by Denis on 22.04.2018.
 */
public class WordsCounter implements Callable<Integer> {
    private File dir;
    private String firstLetter;

    public WordsCounter(File dir, String firstLetter) {
        this.dir = dir;
        this.firstLetter = firstLetter;
    }

    public int searchWords(File file){
        int words = 0;
        String line;
        try(Scanner scanner = new Scanner(new FileInputStream(file))){
            while (scanner.hasNextLine()){
                line = scanner.nextLine();
                words += countWords(line, firstLetter);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("File " + file + " words = " + words);
        return words;
    }

    private int countWords(String line, String firstLetter){
        String[] lineArr = line.split(" |-|_|/");
        return (int)Arrays.stream(lineArr).filter(s -> s.startsWith(firstLetter)).count();
    }

    @Override
    public Integer call() throws Exception {
        int total = 0;
        File[] files = dir.listFiles();
        List<Future<Integer>> result = new ArrayList<>();
        for(File file : files) {
            if (file.isDirectory()) {
                WordsCounter counter = new WordsCounter(file, firstLetter);
                FutureTask<Integer> task = new FutureTask<Integer>(counter);
                result.add(task);
                new Thread(task).start();
            } else {
                total += searchWords(file);
            }
        }
        for(Future<Integer> rez : result){
            total += rez.get();
        }
        return total;
    }
}
