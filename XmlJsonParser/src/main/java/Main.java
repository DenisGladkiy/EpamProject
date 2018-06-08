import entity.Catalog;
import entity.Person;
import parser.DocumentParser;
import parser.XmlParser;
import xml.XmlGenerator;

import javax.swing.text.html.parser.Parser;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Denis on 08.06.2018.
 */
public class Main {
    public static void main(String[] args) {
        generateXmlFile();
        Catalog catalog = readXmlFile("catalog.xml");
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
        List<Person> persons = catalog.getNotebook().getPersons();
        persons.stream().
                filter(p -> p.getCash() >= cash).
                        collect(Collectors.toList()).forEach((p) -> {writeToFile("selectedPeople.txt", p);
                                                                    System.out.println(p);});
    }

    private static void writeToFile(String fileName, Person person){
        File file = new File(fileName);
        try {
            if(!file.exists()){
                file.createNewFile();
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
            PrintWriter pw = new PrintWriter(writer);
            pw.println(person);
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
