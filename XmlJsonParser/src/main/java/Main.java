import entity.Catalog;
import entity.Person;
import json.JsonRetriever;
import parser.DocumentParser;
import parser.JsonParser;
import parser.XmlParser;
import xml.XmlGenerator;

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
        Executor executor = new Executor();
        executor.execute();
    }










}
