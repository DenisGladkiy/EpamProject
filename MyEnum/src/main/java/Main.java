import java.util.Arrays;

/**
 * Created by Denis on 13.03.2018.
 */
public class Main {
    public static void main(String[] args) {
        Colors red = Colors.RED;
        Colors green = Colors.GREEN;
        Colors blue = Colors.BLUE;
        Cars bmw = Cars.BMW;
        Cars toyota = Cars.TOYOTA;
        Cars skoda = Cars.SKODA;
        System.out.println(red + " " + green + " " + blue);
        System.out.println(red.ordinal() + " " + green.ordinal() + " " + blue.ordinal());
        System.out.println(Arrays.toString(Colors.values()));
        System.out.println(Colors.valueOf("RED"));
        System.out.println(bmw.ordinal() + " " + toyota.ordinal() + " " + skoda.ordinal());
        System.out.println(Arrays.toString(Cars.values()));
    }
}
