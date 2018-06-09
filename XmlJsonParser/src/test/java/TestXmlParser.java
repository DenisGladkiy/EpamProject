import entity.Catalog;
import entity.Person;
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
public class TestXmlParser {
    private static final String SOURCE_XML_FILE = "C:\\JAVA\\projects\\epamPractice\\catalog.xml";
    private static DocumentParser<Catalog, String> parser;

    @BeforeClass
    public static void init(){
        ParserFactory factory = new ParserFactory();
        parser = factory.getParser("XML");
    }

    @Test
    public void xmlParserTest(){
        Catalog catalog = parser.parseDocument(SOURCE_XML_FILE);
        List<Person> personList = catalog.getNotebook().getPersons();
        assertNotNull(personList);
        assertTrue(personList.size() > 0);
        assertEquals(5, personList.size());
    }

}
