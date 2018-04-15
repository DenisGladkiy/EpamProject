package searchEngine;

import Entity.Sentence;
import fileReader.MyFileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Denis on 12.04.2018.
 */
public class SearchEngine {
    MyFileReader myFileReader;
    String book;

    public SearchEngine(MyFileReader myFileReader){
        this.myFileReader = myFileReader;
    }

    public SearchEngine(String filePath){
        myFileReader = new MyFileReader(filePath);
        book = myFileReader.readFile();
    }

    public void search(String search) {
        for(Sentence sentence : findSentences(book, search)){
            System.out.println(sentence);
        }
    }

    private List<Sentence> findSentences(String book, String search){
        Sentence sentence;
        List<Sentence> sentences = new ArrayList<>();
        Pattern sentencePattern = Pattern.compile("[À-ßA-Z]+[^.!?\\t]+[.!?\\t]");
        Matcher matcher = sentencePattern.matcher(book);
        while (matcher.find()){
            sentence = new Sentence(matcher.group());
            if(sentence.doesContain(search)){
                sentences.add(sentence);
            }
        }
        return sentences;
    }
}
