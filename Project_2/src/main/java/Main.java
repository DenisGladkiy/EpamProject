import fileReader.MyFileReader;
import searchEngine.SearchEngine;

import java.io.IOException;

/**
 * Created by Denis on 12.04.2018.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        SearchEngine searchEngine = new SearchEngine(new MyFileReader("C:/JAVA/jsp.txt"));
        searchEngine.search();
    }
}
