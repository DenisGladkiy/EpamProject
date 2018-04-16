import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import searchEngine.SearchEngine;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by Denis on 15.04.2018.
 */
@RunWith(Parameterized.class)
public class TestSearchEngine {
    private static SearchEngine searchEngine;
    private String words;
    private Integer searchResult;

    public TestSearchEngine(String words, Integer searchResult){
        this.words = words;
        this.searchResult = searchResult;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testData(){
        return Arrays.asList(new Object[][]{{"web-inf", 78},{"книга", 13},{"сценарий", 11},{"методы класса", 6},{"МЕТОДЫ-КЛАССА", 6}});
    }

    @BeforeClass
    public static void init(){
        searchEngine = new SearchEngine("C:/JAVA/JSP.txt");
    }

    @Test
    public void testSearch(){
        Integer result = searchEngine.doSearch(words).size();
        System.out.println(words);
        assertEquals(searchResult, result);
    }
}
