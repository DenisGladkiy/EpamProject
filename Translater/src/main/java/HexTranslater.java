/**
 * Created by Denis on 28.02.2018.
 */
public class HexTranslater implements Translater {
    public String translate(int input) {
        return "Шестнадцатиричное число = " + Integer.toHexString(input);
    }
}
