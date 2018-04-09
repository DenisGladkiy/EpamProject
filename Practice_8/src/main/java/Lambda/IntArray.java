package Lambda;

import java.util.Random;

/**
 * Created by Denis on 09.04.2018.
 */
public class IntArray {
    Integer[] arr = new Integer[10];

    public IntArray(){
        init();
    }

    private void init(){
        Random rnd = new Random();
        for(int i = 0; i < arr.length; i++){
            arr[i] = rnd.nextInt(10);
        }
    }

    public Integer[] getArr(){
        return arr;
    }
}
