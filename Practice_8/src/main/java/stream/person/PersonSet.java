package stream.person;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Denis on 17.04.2018.
 */
public class PersonSet {
    private Set<Person> people;

    public PersonSet(){
        people = new HashSet<>();
        fillPersonSet();
    }

    private void fillPersonSet(){
        people.add(new Person("John", 24, false));
        people.add(new Person("Анна", 35, true));
        people.add(new Person("Олег", 17, false));
        people.add(new Person("Lana", 19, true));
        people.add(new Person("Bill", 20, false));
        people.add(new Person("Alex", 45, false));
        people.add(new Person("Иван", 30, false));
        people.add(new Person("Сергей", 50, false));
        people.add(new Person("Елена", 25, true));
        people.add(new Person("Amber", 33, true));
        people.add(new Person("July", 55, true));
        people.add(new Person("Ксения", 44, true));
    }

    public Set<Person> getPeople(){
        return people;
    }
}
