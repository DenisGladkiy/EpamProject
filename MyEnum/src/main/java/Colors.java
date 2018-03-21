

/**
 * Created by Denis on 20.03.2018.
 */
public class Colors extends MyAbstractEnum<Colors> {
    private static int ordinal;
    public static final Colors RED = new Colors("red");
    public static final Colors GREEN = new Colors("green");
    public static final Colors BLUE = new Colors("blue");

    private Colors(String name) {
        super(name, ordinal++);
    }
}
