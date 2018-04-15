package Entity;

/**
 * Created by Denis on 12.04.2018.
 */
public class Sentence {
    private String sentence;

    public Sentence(String sentence){
        this.sentence = sentence;
    }

    public int getLength(){
        return sentence.split("\\s+").length;
    }

    public boolean doesContain(String search){
        String tempSentence = sentence.replaceAll("\\s+|,+|:+|-+|;+|_+","");
        String tempSearch = search.replaceAll("\\s+|,+|:+|-+|;+|_+","");
        tempSentence = tempSentence.toLowerCase();
        tempSearch = tempSearch.toLowerCase();
        return tempSentence.contains(tempSearch);
    }

    @Override
    public String toString(){
        return sentence;
    }
}
