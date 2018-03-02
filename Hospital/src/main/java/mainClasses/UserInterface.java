package mainClasses;

import utils.Reader;

/**
 * Created by Denis on 01.03.2018.
 */
public class UserInterface {
    Reader reader;

    public void makeMenu(){
        showAllOptions();
        receiveRequest();
    }

    private void receiveRequest(){
        reader = new Reader();
        String request = reader.readString();
        while(!request.equals("exit")) {
            reply(handleRequest(request));
            showAllOptions();
            request = reader.readString();
        }
    }

    private String handleRequest(String request){
        Controller controller = new Controller(this);
        return controller.handle(request);
    }

    public String askIllness(){
        System.out.println("Введите диагноз");
        return reader.readString();
    }

    public int[] askNumbers(){
        System.out.println("Введите диапазон номеров в формате от-до (пример 1-5)");
        String[] stringNumbers = reader.readString().split("-");
        int[] numbers = new int[2];
        if(stringNumbers.length != 2){
            numbers[0] = -1;
            return numbers;
        }
        int num1 = Integer.parseInt(stringNumbers[0]);
        int num2 = Integer.parseInt(stringNumbers[1]);
        if(num1 < num2) {
            numbers[0] = num1;
            numbers[1] = num2;
        }else{
            numbers[0] = -1;
        }
        return numbers;
    }

    private void reply(String rep){
        System.out.println(rep);
    }

    private void showAllOptions(){
        System.out.println("");
        System.out.println("Для получения общего списка пациентов введите       '0'");
        System.out.println("Для получения списка пациентов с диагнозом введите  '1'");
        System.out.println("Для получения списка пациентов по диапазону номеров '2'");
        System.out.println("Для сортировки общего списка пациентов по фамилии   '3'");
        System.out.println("Для выхода введите 'exit'");
    }
}
