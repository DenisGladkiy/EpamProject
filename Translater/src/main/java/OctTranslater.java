/**
 * Created by Denis on 28.02.2018.
 */
public class OctTranslater implements Translater {
    public String translate(int input) {
        return "Восьмиричное число = " + Integer.toOctalString(input);
    }
}
