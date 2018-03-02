/**
 * Created by Denis on 28.02.2018.
 */
public class BinaryTranslater implements Translater {

    public String translate(int input) {
        return "Двоичное число = " + Integer.toBinaryString(input);
    }
}
