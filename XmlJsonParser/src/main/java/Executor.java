import entity.Catalog;
import entity.Currency;
import entity.Person;
import parser.DocumentParser;
import parser.ParserFactory;
import xml.XmlGenerator;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.*;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created by Denis on 09.06.2018.
 */
public class Executor {
    private static final String XML_RESULT_FILE = "selectedPeople.txt";
    private static final String JSON_RESULT_FILE = "selectedCurrencies.txt";
    private static final String SOURCE_XML_FILE = "catalog.xml";
    private static final String URL = "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json";

    public void execute(){
        ParserFactory factory = new ParserFactory();
        DocumentParser<Catalog, String> xmlParser = factory.getParser("XML");
        DocumentParser<List<Currency>, String> jsonParser = factory.getParser("JSON");
        generateXmlFile();
        Catalog catalog = xmlParser.parseDocument(SOURCE_XML_FILE);
        selectByCash(catalog, 10000);
        List<Currency> currencies = jsonParser.parseDocument(URL);
        selectByCurrencyId(currencies, "USD","EUR","RUB");
    }

    private void generateXmlFile(){
        XmlGenerator generator = new XmlGenerator();
        try {
            generator.generateXmlFile();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    private void selectByCash(Catalog catalog, int cash){
        File file = new File(XML_RESULT_FILE);
        try {
            prepareFile(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Person> persons = catalog.getNotebook().getPersons();
        persons.stream().
                filter(p -> p.getCash() >= cash).
                collect(Collectors.toList()).forEach(p -> {writeToFile(file, p);
            System.out.println(p);});
    }

    private void selectByCurrencyId(List<Currency> currencies, String...currId){
        File file = new File(JSON_RESULT_FILE);
        try {
            prepareFile(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        currencies.stream().filter(currency -> isRequired(currency, currId)).
                collect(Collectors.toList()).forEach(currency -> {writeToFile(file, currency);});
        readFileToConsole(file);
    }

    private void readFileToConsole(File file){
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()){
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private boolean isRequired(Currency currency, String...currId){
        for (String s : currId) {
            if(s.equals(currency.getId())){
                return true;
            }
        }
        return false;
    }

    private void prepareFile(File file) throws IOException {
        if (!file.exists()) {
            file.createNewFile();
        } else {
            PrintWriter pw = new PrintWriter(file);
            pw.close();
        }
    }

    private <T> void writeToFile(File file, T object){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
            PrintWriter pw = new PrintWriter(writer);
            pw.println(object);
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
