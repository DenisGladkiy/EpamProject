package Lambda;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by Denis on 09.04.2018.
 */
public class Starter {

    public static void main(String[] args) {
        sortArray();
        sortList();
    }

    private static void sortArray(){
        IntArray intArray = new IntArray();
        Integer[] testArray = intArray.getArr();
        System.out.println("Before " + Arrays.toString(testArray));
        Arrays.sort(testArray, (a,b) -> b - a);
        System.out.println("After " + Arrays.toString(testArray));
    }

    private static void sortList(){
        StringList stringList = new StringList();
        List<String> testList = stringList.getStrings();
        System.out.println("Before " + testList);
        Collections.sort(testList, (a,b) -> b.compareTo(a));
        System.out.println("After " + testList);
    }
}
