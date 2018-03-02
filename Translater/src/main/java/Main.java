import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * Created by Denis on 28.02.2018.
 */
public class Main {

    private int input;
    private String result;

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println("Введите целое число");
        main.doTranslation();
    }

    private void doTranslation(){
        Translater[] translaters = new Translater[3];
        Reader reader = new Reader();
        translaters[0] = new BinaryTranslater();
        translaters[1] = new OctTranslater();
        translaters[2] = new HexTranslater();
        Writer writer = new Writer();
        input = reader.read();
        for(Translater t : translaters){
            result = t.translate(input);
            writer.write(result);
        }
    }
}
