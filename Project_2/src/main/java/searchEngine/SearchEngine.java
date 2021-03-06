package searchEngine;

import Entity.Sentence;
import fileReader.MyFileReader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.*;

/**
 * Created by Denis on 12.04.2018.
 */
public class SearchEngine {
    static Logger logger = Logger.getLogger(SearchEngine.class);
    private MyFileReader myFileReader;
    private String book;

    public SearchEngine(String filePath){
        myFileReader = new MyFileReader(filePath);
        logger.info("myFileReader created with filepath = " + filePath);
        book = myFileReader.readFile();
    }

    public List<Sentence> doSearch(String search) {
        if(book != null) {
            List<Sentence> sentences = findSentences(search);
            Collections.sort(sentences, (a, b) -> a.getLength() - b.getLength());
            return sentences;
        }else {
            logger.info("book = null");
            return null;
        }
    }

    private List<Sentence> findSentences(String search){
        Sentence sentence;
        List<Sentence> sentences = new ArrayList<>();
        Pattern sentencePattern = Pattern.compile("[А-ЯA-Z0-9]+[^.!?\\t\\n]+[.!?\\t\\n]+");
        Matcher matcher = sentencePattern.matcher(book);
        while (matcher.find()){
            sentence = new Sentence(matcher.group());
            if(sentence.doesContain(search)){
                System.out.println(sentence);
                sentences.add(sentence);
            }
        }
        return sentences;
    }
}
