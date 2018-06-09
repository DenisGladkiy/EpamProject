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
    private DocumentParser<Catalog, String> xmlParser;
    private DocumentParser<List<Currency>, String> jsonParser;
    private File xmlResultFile;
    private File jsonResultFile;

    public void execute(){
        init();
        Catalog catalog = xmlParser.parseDocument(SOURCE_XML_FILE);
        List<Person> selectedPerson = selectByCash(catalog, 10000);
        writeToFile(xmlResultFile, selectedPerson);
        writeToConsole(selectedPerson);
        List<Currency> currencies = jsonParser.parseDocument(URL);
        List<Currency> selectedCurrency =  selectByCurrencyId(currencies, "USD","EUR","RUB");
        writeToFile(jsonResultFile, selectedCurrency);
        readFileToConsole(jsonResultFile);
    }

    public List<Person> selectByCash(Catalog catalog, int cash){
        List<Person> persons = catalog.getNotebook().getPersons();
        List<Person> selectedPerson = persons.stream().filter(p -> p.getCash() >= cash).
                collect(Collectors.toList());
        return selectedPerson;
    }

    public List<Currency> selectByCurrencyId(List<Currency> currencies, String...currId){
        List<Currency> selectedCurrency = currencies.stream().filter(currency -> isRequired(currency, currId)).
                collect(Collectors.toList());
        return selectedCurrency;
    }

    private void init(){
        ParserFactory factory = new ParserFactory();
        xmlParser = factory.getParser("XML");
        jsonParser = factory.getParser("JSON");
        generateXmlFile();
        xmlResultFile = new File(XML_RESULT_FILE);
        jsonResultFile = new File(JSON_RESULT_FILE);
        try {
            prepareFile(xmlResultFile);
            prepareFile(jsonResultFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    private <T> void writeToFile(File file, List<T> list){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
            PrintWriter pw = new PrintWriter(writer);
            list.forEach(t -> pw.println(t));
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private <T> void writeToConsole(List<T> list){
        list.forEach(t -> System.out.println(t));
    }
}
