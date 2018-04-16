package Lambda;

import java.util.*;
import java.util.function.Predicate;

/**
 * Created by Denis on 09.04.2018.
 */
public class Starter {
    private static List<String> testList;

    public static void main(String[] args) {
        testLambda();
    }

    private static void testLambda(){
        IntArray intArray = new IntArray();
        Integer[] testArray = intArray.getArr();
        StringList stringList = new StringList();
        testList = stringList.getStrings();
        sortArray(testArray);
        sortList(testList);
        System.out.println(handleInt(testArray, x -> x % 2 == 0));
        System.out.println(handleString(testList, s -> s.startsWith("s")));
        testFuncInterface();
    }

    private static void sortArray(Integer[] testArray){
        System.out.println("Before " + Arrays.toString(testArray));
        Arrays.sort(testArray, (a,b) -> b - a);
        System.out.println("After " + Arrays.toString(testArray));
    }

    private static void sortList(List<String> testList){
        System.out.println("Before " + testList);
        Collections.sort(testList, (a,b) -> b.compareTo(a));
        System.out.println("After " + testList);
    }

    private static Integer handleInt(Integer[] arr, Predicate<Integer> p){
        int index = 0;
        int total = 0;
        for(Integer i : arr){
            if(p.test(i)){
                index++;
                total += i;
            }
        }
        System.out.println(total + " " + index);
        return total / index;
    }

    private static List<String> handleString(List<String> strings, Predicate<String> p){
        List<String> temp = new ArrayList<>();
        for(String s : strings){
            if(p.test(s)){
                temp.add(s);
            }
        }
        return temp;
    }

    private static void testFuncInterface(){
        IsExisting isExisting = (string) -> string != null;
        ToUpperCase toUpperCase = (initial) -> initial = initial.toUpperCase();
        List<String> temp = new ArrayList<>();
        for(int i = 0; i < testList.size(); i++){
            if(isExisting.check(testList.get(i))){
                testList.set(i, toUpperCase.convert(testList.get(i)));
        }};
        System.out.println(testList);
    }
}
