import entity.Currency;
import org.junit.BeforeClass;
import org.junit.Test;
import parser.DocumentParser;
import parser.ParserFactory;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by Denis on 09.06.2018.
 */
public class TestJsonParser {
    private static final String URL = "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json";
    private static DocumentParser<List<Currency>, String> parser;

    @BeforeClass
    public static void init(){
        ParserFactory factory = new ParserFactory();
        parser = factory.getParser("JSON");
    }

    @Test
    public void xmlParserTest(){
        List<Currency> currencies = parser.parseDocument(URL);
        assertNotNull(currencies);
        assertTrue(currencies.size() > 0);
        assertEquals(60, currencies.size());
    }
}
