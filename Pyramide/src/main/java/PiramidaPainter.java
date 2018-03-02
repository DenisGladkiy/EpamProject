/**
 * Created by Denis on 28.02.2018.
 */
public class PiramidaPainter {
    private int[] line;

    public void paint(int size){
        line = new int[size * 2 - 1];
        if(size <= 9){
            for(int i = 1; i <= size; i++){
                drawLine(doLine(i));
            }
        }
    }

    private void drawLine(int[] numbers) {
        for(int num : numbers){
            if(num == 0){
                System.out.print(" ");
            }else{
                System.out.print(num);
            }
        }
        System.out.print("\n");
    }

    private int[] doLine(int number){
        int middle = line.length / 2;
        int counter = number;
        for(int i = middle; counter > 0; i--){
            line[i] = counter;
            counter--;
        }
        for(int i = middle; number > 0; i++){
            line[i] = number;
            number--;
        }
        return line;
    }
}
