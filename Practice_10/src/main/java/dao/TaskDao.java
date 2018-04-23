package dao;

import dao.entity.Task;

import java.sql.Connection;
import java.util.List;

/**
 * Created by Denis on 23.04.2018.
 */
public class TaskDao implements AbstractDao<Task> {
    private Connection connection;

    public TaskDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Task> getAll() {
        return null;
    }

    @Override
    public Task getById(int primaryKey) {
        return null;
    }

    @Override
    public void removeById(int primaryKey) {

    }
}
