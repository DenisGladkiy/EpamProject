package entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Denis on 08.06.2018.
 */
public class Notebook {
    private List<Person> persons;

    public Notebook(){
        persons = new ArrayList<>();
    }

    public void addPerson(Person person){
        persons.add(person);
    }

    public List<Person> getPersons(){
        return persons;
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "persons=" + persons +
                '}';
    }
}
