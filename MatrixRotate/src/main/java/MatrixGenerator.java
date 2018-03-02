import java.util.Random;

/**
 * Created by Denis on 01.03.2018.
 */
public class MatrixGenerator {

    public int[][] makeMatrix(int size){
        Random rnd = new Random();
        int[][] matrix = new int[size][size];
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                matrix[i][j] = rnd.nextInt(10);
            }
        }
        return matrix;
    }
}
