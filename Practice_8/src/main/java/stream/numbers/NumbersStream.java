package stream.numbers;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Denis on 17.04.2018.
 */
public class NumbersStream {

    public static void main(String[] args) {
        streamNumbers();
    }

    public static void streamNumbers(){
        Stream.iterate(10, n -> n + 10).
                limit(10).map((n) -> n / 2).
                collect(Collectors.toList()).
                forEach(System.out::println);
    }
}
