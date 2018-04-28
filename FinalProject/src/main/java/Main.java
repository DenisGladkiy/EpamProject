import mvc.model.dao.AbstractDao;
import mvc.model.dao.DaoManager;

/**
 * Created by Denis on 28.04.2018.
 */
public class Main {
    public static void main(String[] args) {
        DaoManager manager = new DaoManager();
        AbstractDao aDao = manager.getDao("Activity");
        System.out.println(aDao.getAll());
    }
}
