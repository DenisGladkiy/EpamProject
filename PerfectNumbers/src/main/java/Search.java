import java.util.Arrays;

/**
 * Created by Denis on 28.02.2018.
 */
public class Search {

    public void searchNumbers(int input){
        Writer writer = new Writer();
        int [] numbers = getNumArray(input);
        for(int number : numbers){
            if(isPerfect(number)){
                writer.write(number);
            }
        }
    }

    private int [] getNumArray(int input){
        int [] num = new int[input];
        for(int i = 1; i <= input; i++){
            num[i-1] = i;
        }
        return num;
    }

    private boolean isPerfect(int number){
        int [] dividers = new int [number];
        int tempResult = 0;
        for(int i = 1; i < number; i++){
            if((number % i) == 0){
                dividers[i-1] = i;
            }
        }
        for(int divider : dividers){
            tempResult += divider;
        }
        return number == tempResult;
    }
}
