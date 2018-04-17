package stream.person;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Denis on 17.04.2018.
 */
public class Main {
    public static void main(String[] args) {
        PersonSet personSet = new PersonSet();
        Set<Person> people = personSet.getPeople();
        selectMen(people);
        System.out.println(averageWomen(people));
    }

    private static void selectMen(Set<Person> people){
        people.stream().
                filter(p -> p.isFemale() == false && p.getAge() >= 18 && p.getAge() <= 30).
                collect(Collectors.toList()).forEach(System.out::println);
    }

    private static double averageWomen(Set<Person> people){
        return people.stream().
                filter(p -> p.isFemale() == true).
                mapToInt(Person::getAge).average().getAsDouble();
    }
}
