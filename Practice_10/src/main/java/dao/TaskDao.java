package dao;

import dao.entity.Task;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
        String query = "select * from task";
        return getTask(query);
    }

    @Override
    public List<Task> getByForeignKey(int key) {
        String query = "SELECT * FROM TASK WHERE NUMBER=" + key;
        return getTask(query);
    }

    @Override
    public Task getById(int primaryKey) {
        return null;
    }

    @Override
    public void addByForeignKey(Task task) {
    }

    @Override
    public void removeById(int primaryKey) {
    }

    private List<Task> getTask(String query){
        ArrayList<Task> tasks = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()){
                tasks.add(new Task(rs.getInt(1), rs.getString(2), rs.getInt(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tasks;
    }
}
