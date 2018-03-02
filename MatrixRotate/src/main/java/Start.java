/**
 * Created by Denis on 01.03.2018.
 */
public class Start {

    public static void main(String[] args) {
        start();
    }

    private static void start(){
        int[][] matrix;
        int size;
        Reader reader = new Reader();
        System.out.println("Введите размер массива 0 - 100");
        size = reader.read();
        if((size > 100) || (size < 0)){
            return;
        }
        MatrixGenerator generator = new MatrixGenerator();
        MatrixRotator rotator = new MatrixRotator();
        Writer writer = new Writer();
        matrix = generator.makeMatrix(size);
        writer.write(matrix);
        System.out.println("");
        writer.write(rotator.rotate(matrix));
    }

}
