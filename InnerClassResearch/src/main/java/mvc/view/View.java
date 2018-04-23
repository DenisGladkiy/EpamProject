package mvc.view;

import controller.Controller;
import utils.Reader;

/**
 * Created by Denis on 14.03.2018.
 */
public class View {
    Reader reader;
    Controller controller;

    public View(Controller controller){
        this.controller = controller;
    }

    public void menu(){
        mainMenu();
        receiveRequest();
    }

    private void receiveRequest(){
        reader = new Reader();
        String request = reader.readString();
        while(!request.equals("exit")) {
            reply(handleRequest(request));
            request = reader.readString();
        }
    }

    public void mainMenu(){
        System.out.println("Создать отдел - 1");
        System.out.println("Завезти товар - 2");
        System.out.println("Удалить отдел - 3");
        System.out.println("Сортировать отделы - 4");
    }

    private void reply(String reply){
        System.out.println(reply);
    }

    private String handleRequest(String request){
        return controller.handleRequest(request);
    }

    public String askDepartment(){
        System.out.println("Название,Количество товара,Этаж");
        return reader.readString();
    }

    public String askGoodsNumber(){
        System.out.println("Название отдела-количество товара");
        return reader.readString();
    }

    public String askDelDepartment(){
        System.out.println("Название отдела");
        return reader.readString();
    }

}
