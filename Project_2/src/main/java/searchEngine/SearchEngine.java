package searchEngine;

import Entity.Sentence;
import fileReader.MyFileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Denis on 12.04.2018.
 */
public class SearchEngine {
    MyFileReader myFileReader;

    public SearchEngine(MyFileReader myFileReader){
        this.myFileReader = myFileReader;
    }

    public void search() throws IOException {
        String book = myFileReader.readFile();
        for(String sentence : findSentences(book)){
            System.out.println(sentence);
        }
    }

    private List<String> findSentences(String book){
        List<String> sentences = new ArrayList<>();
        //Pattern sentencePattern = Pattern.compile("\\.\\s+|!\\s+|\\?\\s+|\\t+");
        Pattern sentencePattern = Pattern.compile("[À-ßA-Z]+[^.!?\\t]+[.!?\\t]");
        Matcher matcher = sentencePattern.matcher(book);
        while (matcher.find()){
            sentences.add(matcher.group());
        }
        //sentences = Arrays.asList(sentencePattern.split(book));
        return sentences;
    }
}
