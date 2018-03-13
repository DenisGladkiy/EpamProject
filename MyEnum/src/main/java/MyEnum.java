/**
 * Created by Denis on 13.03.2018.
 */
public class MyEnum{
    public static final MyEnum ONE = new MyEnum("ONE", 0);
    public static final MyEnum TWO = new MyEnum("TWO", 1);
    public static final MyEnum THREE = new MyEnum("THREE", 2);

    final String name;
    final int order;

    private MyEnum(String name, int order){
        this.name = name;
        this.order = order;
    }

    public String toString(){
        return name;
    }
}
