import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * Created by Denis on 27.03.2018.
 */
public class Controller {
    ConsoleReader reader;
    ListAndSet listAndSet;

    public Controller(ListAndSet listAndSet){
        this.listAndSet = listAndSet;
        reader = new ConsoleReader();
    }

    public void work(){
        List list;
        Set set;
        String request;
        String[] numbers;
        int size, from, to;
        System.out.println("Задайте количество и диапазон чисел в формате 10,1-10");
        while(true){
            request = reader.readLine();
            if(request.equalsIgnoreCase("exit")){
                return;
            }
            numbers = request.split("(,|-)");
            size = Integer.parseInt(numbers[0]);
            from = Integer.parseInt(numbers[1]);
            to = Integer.parseInt(numbers[2]);
            list = listAndSet.generateList(size,from,to);
            set = listAndSet.generateSet(size,from,to);
            System.out.println(list);
            System.out.println(set);
        }
    }
}
