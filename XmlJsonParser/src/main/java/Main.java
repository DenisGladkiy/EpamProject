import entity.Catalog;
import entity.Person;
import parser.DocumentParser;
import parser.XmlParser;
import xml.XmlGenerator;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Denis on 08.06.2018.
 */
public class Main {
    private static final String RESULT_FILE_NAME = "selectedPeople.txt";
    private static final String SOURCE_XML_FILE = "catalog.xml";

    public static void main(String[] args) {
        generateXmlFile();
        Catalog catalog = readXmlFile(SOURCE_XML_FILE);
        selectByCash(catalog, 10000);
    }

    private static void generateXmlFile(){
        XmlGenerator generator = new XmlGenerator();
        try {
            generator.generateXmlFile();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    private static Catalog readXmlFile(String file){
        DocumentParser<Catalog, String> parser = new XmlParser();
        return parser.parseDocument(file);
    }

    private static void selectByCash(Catalog catalog, int cash){
        File file = new File(RESULT_FILE_NAME);
        try {
            prepareFile(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Person> persons = catalog.getNotebook().getPersons();
        persons.stream().
                filter(p -> p.getCash() >= cash).
                        collect(Collectors.toList()).forEach((p) -> {writeToFile(file, p);
                                                                    System.out.println(p);});
    }

    private static void prepareFile(File file) throws IOException {
        if (!file.exists()) {
            file.createNewFile();
        } else {
            PrintWriter pw = new PrintWriter(file);
            pw.println("");
            pw.close();
        }
    }

    private static void writeToFile(File file, Person person){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
            PrintWriter pw = new PrintWriter(writer);
            pw.println(person);
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
