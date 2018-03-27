import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Denis on 27.03.2018.
 */
public class ListAndSet {
    private List<Integer> list;
    private Set<Integer> set;

    public List generateList(int size, int from, int to){
        if(from > to){
            int temp = from;
            from = to;
            to = temp;
        }
        int value = from;
        list = new ArrayList();
        for(int i = 0; i < size; i++){
            list.add(value);
            value++;
            if(value > to){
                value=from;
            }
        }
        return list;
    }

    public Set generateSet(int size, int from, int to){
        if(from > to){
            int temp = from;
            from = to;
            to = temp;
        }
        int value = from;
        set = new HashSet<>();
        for(int i = 0; i < size; i++){
            set.add(value);
            value++;
            if(value > to){
                System.out.println("Максимальный размер сета с указанным диапазоном = " + (to-from+1));
                break;
            }
        }
        return set;
    }
}
