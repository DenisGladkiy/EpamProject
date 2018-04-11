package Lambda;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Denis on 09.04.2018.
 */
public class StringList {
    List<String> strings;

    public StringList(){
        init();
    }

    private void init(){
        strings = Arrays.asList("one", "two", "three", "four", "five", "six", "seven");
    }

    public List<String> getStrings(){
        return strings;
    }
}
