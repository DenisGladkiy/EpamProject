package view;

/**
 * Created by Denis on 23.03.2018.
 */
public class ConsoleWriter {
    public static final String STUDENT = "Введите Фамилию, Имя, Дату рождения, Телефон, Адрес студента";
    public static final String MISTAKE = "Ошибка формата данных. Повторите ввод";
    public static final String CONFIRM = "Данные студента внесены в журнал";

    public void writeConsole(String string){
        System.out.println(string);
    }

    public void askStudent(){
        System.out.println(STUDENT);
    }

    public void showOptions(){
        System.out.println("Выход - exit");
        System.out.println("Все студенты - all");
    }

    public void confirm(){
        System.out.println(CONFIRM);
    }

    public void sayMistake(){
        System.out.println(MISTAKE);
    }
}
