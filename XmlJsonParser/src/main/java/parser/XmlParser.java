package parser;

import entity.Catalog;
import entity.Notebook;
import entity.Person;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * Created by Denis on 08.06.2018.
 */
public class XmlParser implements DocumentParser<Catalog, String> {
    private Document domDocument;

    @Override
    public Catalog parseDocument(String fileName) {
        File file = new File(fileName);
        return parseFile(file);
    }

    private Catalog parseFile(File file){
        Catalog catalog = null;
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = null;
        try {
            docBuilder = factory.newDocumentBuilder();
            domDocument = docBuilder.parse(file);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Node node = domDocument.getFirstChild();
        if(node.getNodeName().equals("catalog")){
            catalog = createCatalog(domDocument);
        }
        return catalog;
    }

    private Catalog createCatalog(Document domDocument) {
        Catalog catalog = new Catalog();
        Notebook notebook;
        Node node;
        NodeList nodeList = domDocument.getElementsByTagName("notebook");
        for(int i = 0; i < nodeList.getLength(); i++){
            node = nodeList.item(i);
            notebook = createNotebook(node);
            catalog.setNotebook(notebook);
        }
        return catalog;
    }

    private Notebook createNotebook(Node notebookNode) {
        Notebook notebook = new Notebook();
        Node node;
        Person person;
        NodeList nodeList = notebookNode.getChildNodes();
        for(int i = 0; i < nodeList.getLength(); i++){
            node = nodeList.item(i);
            if(node.getNodeName().equals("person")) {
                person = createPerson(node);
                notebook.addPerson(person);
            }
        }
        return notebook;
    }

    private Person createPerson(Node personNode) {
        Person person;
        person = new Person();
        String personId = personNode.getAttributes().getNamedItem("id").getNodeValue();
        person.setId(Integer.parseInt(personId));
        NodeList nodeList = personNode.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            String element = node.getNodeName();
            switch (element) {
                case "name":
                    person.setName(node.getTextContent());
                    break;
                case "address":
                    person.setAddress(node.getTextContent());
                    break;
                case "cash":
                    person.setCash(Integer.valueOf(node.getTextContent()));
                    break;
                case "education":
                    person.setEducation(node.getTextContent());
                    break;
            }
        }
        return person;
    }
}
