import java.util.Arrays;

/**
 * Created by Denis on 28.02.2018.
 */
public class Writer {
    public void write(String result){
        System.out.println(result);
    }

    public void write(int result){
        System.out.println(result);
    }

    public void write(int[][] matrix){
        for(int[] column : matrix){
//            for(int element : column){
//                System.out.print(element);
//            }
//            System.out.print("\n");
            System.out.println(Arrays.toString(column));
        }
    }
}
