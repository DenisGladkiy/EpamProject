import entity.Catalog;
import entity.Currency;
import entity.Notebook;
import entity.Person;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Denis on 09.06.2018.
 */
public class TestExecutor {
    private static Catalog catalog;
    private static List<Currency> currencies;
    private static Executor executor;

    @BeforeClass
    public static void init(){
        catalog = createCatalog();
        currencies = createCurrencyList();
        executor = new Executor();
    }

    @Test
    public void selectByCashTest(){
        List<Person> selectedPerson = executor.selectByCash(catalog, 10000);
        assertNotNull(selectedPerson.get(0));
        assertEquals(2, selectedPerson.size());
    }

    @Test
    public void selectByCurrencyIdTest(){
        List<Currency> selectedCurrency = executor.selectByCurrencyId(currencies, "USD","EUR","RUB");
        assertNotNull(selectedCurrency.get(0));
        assertEquals(3, selectedCurrency.size());
    }

    private static List<Currency> createCurrencyList() {
        List<Currency> currencies = new ArrayList<>();
        currencies.add(new Currency("Dollar", 26.1f, "USD"));
        currencies.add(new Currency("Euro", 30.5f, "EUR"));
        currencies.add(new Currency("Rubl", 0.4f, "RUB"));
        currencies.add(new Currency("Pound", 36.3f, "GBP"));
        return currencies;
    }

    private static Catalog createCatalog() {
        Notebook notebook = new Notebook();
        notebook.addPerson(new Person(1, "Alex", "Pushkina av. 1", 11000, "sa"));
        notebook.addPerson(new Person(2, "Dima", "Long st. 100", 15000, "sa"));
        notebook.addPerson(new Person(3, "Yura", "Short st. 10", 9999, "sa"));
        return new Catalog(notebook);
    }


}
