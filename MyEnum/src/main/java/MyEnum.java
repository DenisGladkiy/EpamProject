import java.util.Arrays;

/**
 * Created by Denis on 13.03.2018.
 */
public class MyEnum{
    public static final MyEnum ONE = new MyEnum("ONE", 0);
    public static final MyEnum TWO = new MyEnum("TWO", 1);
    public static final MyEnum THREE = new MyEnum("THREE", 2);

    private final String name;
    private final int order;
    private static MyEnum[] values = new MyEnum[]{ONE, TWO, THREE};

    private MyEnum(String name, int order){
        this.name = name;
        this.order = order;
    }

    public String toString(){
        return name;
    }

    public static MyEnum[] values(){
        return values;
    }

    public static MyEnum valueOf(String name){
        for(MyEnum me : values){
            if(me.name() == name){
                return me;
            }
        }
        return null;
    }

    public int ordinal(){
        return order;
    }

    public String name(){
        return name;
    }
}
