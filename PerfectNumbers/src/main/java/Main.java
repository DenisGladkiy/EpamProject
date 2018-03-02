/**
 * Created by Denis on 28.02.2018.
 */


public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.doSearch();
    }

    private void doSearch(){
        int input = 0;
        Search search = new Search();
        Reader reader = new Reader();
        input = reader.read();
        if(input < 0){
            System.out.println("Ошибка ввода");
            return;
        }
        search.searchNumbers(input);
    }
}
