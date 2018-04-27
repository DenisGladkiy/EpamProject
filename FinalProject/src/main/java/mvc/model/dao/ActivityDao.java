package mvc.model.dao;

import mvc.model.entity.Activity;

import java.util.List;

/**
 * Created by Denis on 27.04.2018.
 */
public class ActivityDao implements AbstractDao<Activity> {

    public List<Activity> getAll() {
        return null;
    }

    public List<Activity> getByUserId(int userId) {
        return null;
    }

    public Activity getById(int id) {
        return null;
    }

    public boolean insert(Activity activity) {
        return false;
    }

    public boolean update(Activity activity) {
        return false;
    }

    public boolean delete(Activity activity) {
        return false;
    }

    public boolean isExist(Activity activity) {
        return false;
    }
}
