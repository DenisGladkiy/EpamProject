/**
 * Created by Denis on 20.03.2018.
 */
public class Cars extends MyAbstractEnum<Cars> {
    private static int ordinal;
    public static final Cars BMW = new Cars("bmw");
    public static final Cars TOYOTA = new Cars("toyota");
    public static final Cars SKODA = new Cars("skoda");

    protected Cars(String name) {
        super(name, ordinal++);
    }
}
