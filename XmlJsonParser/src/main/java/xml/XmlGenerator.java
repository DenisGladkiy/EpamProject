package xml;

import entity.Catalog;
import entity.Person;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.List;

/**
 * Created by Denis on 08.06.2018.
 */
public class XmlGenerator {

    private Catalog catalog;

    public XmlGenerator() {
        catalog = new CatalogInit().createCatalog();
    }

    public void generateXmlFile() throws ParserConfigurationException, TransformerException {
        List<Person> persons = catalog.getNotebook().getPersons();
        DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
        Document document = documentBuilder.newDocument();
        Element catalogElement = document.createElement("catalog");
        document.appendChild(catalogElement);
        Element notebookElement = document.createElement("notebook");
        catalogElement.appendChild(notebookElement);
        for(Person person : persons){
            addPersonElement(person, document, notebookElement);
        }
        writeFile(document);
    }

    private void addPersonElement(Person person, Document document, Element notebookElement){
        Element personElement = document.createElement("person");
        notebookElement.appendChild(personElement);
        Attr attr = document.createAttribute("id");
        attr.setValue(String.valueOf(person.getId()));
        personElement.setAttributeNode(attr);
        Element name = document.createElement("name");
        name.appendChild(document.createTextNode(person.getName()));
        personElement.appendChild(name);
        Element address = document.createElement("address");
        address.appendChild(document.createTextNode(person.getAddress()));
        personElement.appendChild(address);
        Element cash = document.createElement("cash");
        cash.appendChild(document.createTextNode(String.valueOf(person.getCash())));
        personElement.appendChild(cash);
        Element education = document.createElement("education");
        education.appendChild(document.createTextNode(person.getEducation()));
        personElement.appendChild(education);
    }

    private void writeFile(Document document) throws TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
        DOMSource source = new DOMSource(document);
        StreamResult result =  new StreamResult(new File("catalog.xml"));
        transformer.transform(source, result);
    }
}
