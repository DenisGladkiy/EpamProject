package entity;

/**
 * Created by Denis on 08.06.2018.
 */
public class Catalog {
    private Notebook notebook;

    public Catalog(){}

    public Catalog(Notebook notebook) {
        this.notebook = notebook;
    }

    public Notebook getNotebook() {
        return notebook;
    }

    public void setNotebook(Notebook notebook) {
        this.notebook = notebook;
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "notebook=" + notebook +
                '}';
    }
}
