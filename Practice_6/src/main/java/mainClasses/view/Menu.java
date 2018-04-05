package mainClasses.view;

/**
 * Created by Denis on 30.03.2018.
 */
public interface Menu {
    String ZERO = "Для получения общего списка пациентов введите       '0'";
    String ONE = "Для получения списка пациентов с диагнозом введите  '1'";
    String TWO = "Для получения списка пациентов по диапазону номеров '2'";
    String THREE = "Для сортировки общего списка пациентов по фамилии   '3'";
    String FOUR = "Для сохранения пациентов в файл                     '4'";
    String FIVE = "Для чтения пациентов из файла                       '5'";
    String EXIT = "Для выхода введите 'exit'";
    String ASK_NUMBERS = "Введите диапазон номеров в формате от-до (пример 1-5)";
    String ASK_ILLNESS = "Введите диагноз";
    String ASK_FILE = "Введите имя файла и путь";
    String MISTAKE = "Ошибка ввода";
    String NO_RESULT = "Запрос не вернул результатов";
    String UNKNOWN = "Неизвестный запрос";
}
