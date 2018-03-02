/**
 * Created by Denis on 01.03.2018.
 */
public class MatrixRotator {

    public int[][] rotate(int[][] matrix){
        int size = matrix.length;
        int[][] rotatedMatrix = new int[size][size];
        for(int i = 0; i < size; i++){
            for(int j = size - 1; j >= 0; j--){
                rotatedMatrix[size - j-1][i] = matrix[i][j];
            }
        }
        return rotatedMatrix;
    }

}
