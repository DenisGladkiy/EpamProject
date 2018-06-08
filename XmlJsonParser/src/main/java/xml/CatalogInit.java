package xml;

import entity.Catalog;
import entity.Notebook;
import entity.Person;

/**
 * Created by Denis on 08.06.2018.
 */
public class CatalogInit {

    public Catalog createCatalog(){
        return new Catalog(createNotebook());
    }

    private Notebook createNotebook(){
        Notebook notebook = new Notebook();
        fillInNotebook(notebook);
        return notebook;
    }

    private void fillInNotebook(Notebook notebook){
        notebook.addPerson(new Person(1, "Alex", "Pushkina av. 1", 8000, "sa"));
        notebook.addPerson(new Person(2, "Dima", "Long st. 100", 15000, "sa"));
        notebook.addPerson(new Person(3, "Yura", "Short st. 10", 9999, "sa"));
        notebook.addPerson(new Person(4, "Vladimir", "Round st. 100", 22000, "sa"));
        notebook.addPerson(new Person(5, "John", "Far st. 9", 7000, "sa"));
    }
}
