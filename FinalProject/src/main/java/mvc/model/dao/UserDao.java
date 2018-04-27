package mvc.model.dao;

import mvc.model.entity.User;

import java.util.List;

/**
 * Created by Denis on 27.04.2018.
 */
public class UserDao implements AbstractDao<User> {
    public List<User> getAll() {
        return null;
    }

    public User getById(int id) {
        return null;
    }

    public boolean insert(User user) {
        return false;
    }

    public boolean update(User user) {
        return false;
    }

    public boolean delete(User user) {
        return false;
    }

    public boolean isExist(User user) {
        return false;
    }
}
