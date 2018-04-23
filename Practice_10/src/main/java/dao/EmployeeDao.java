package dao;

import dao.entity.Employee;

import java.sql.Connection;
import java.util.List;

/**
 * Created by Denis on 23.04.2018.
 */
public class EmployeeDao implements AbstractDao<Employee> {
    private Connection connection;

    public EmployeeDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Employee> getAll() {
        return null;
    }

    @Override
    public Employee getById(int primaryKey) {
        return null;
    }

    @Override
    public void removeById(int primaryKey) {

    }
}
