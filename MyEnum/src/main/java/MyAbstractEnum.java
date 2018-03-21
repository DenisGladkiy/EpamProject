import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Denis on 13.03.2018.
 */
public abstract class MyAbstractEnum<E extends MyAbstractEnum<E>> implements Comparable<E>, Serializable {
    private final String name;
    private final int ordinal;
    private static List<MyAbstractEnum> values = new ArrayList<>();

    protected MyAbstractEnum(String name, int ordinal){
        this.name = name;
        this.ordinal = ordinal;
        values.add(this);
    }

    public String toString(){
        return name;
    }

    public static MyAbstractEnum[] values(){
        MyAbstractEnum[] me = new MyAbstractEnum[values.size()];
        return values.toArray(me);
    };

    public static MyAbstractEnum valueOf(String name){
        for(MyAbstractEnum me : values){
            if(me.name().equalsIgnoreCase(name)){
                return me;
            }
        }
        return null;
    }

    public int ordinal(){
        return ordinal;
    }

    public String name(){
        return name;
    }

    public final int compareTo(E e){
        return ordinal - e.ordinal();
    }
}
