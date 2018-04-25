package dao;

import dao.entity.Department;
import dao.entity.Entity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Denis on 23.04.2018.
 */
public class DepartmentDao implements AbstractDao<Department> {
    private Connection connection;

    public DepartmentDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Department> getAll() {
        String query = "SELECT * FROM DEPARTMENTS";
        return getDepartment(query);
    }

    @Override
    public List<Department> getByForeignKey(int key) {
        return null;
    }

    @Override
    public Department getById(int primaryKey) {
        return null;
    }

    @Override
    public void addByForeignKey(Department department) {
    }

    @Override
    public void removeById(int primaryKey) {
    }

    private List<Department> getDepartment(String employee){
        ArrayList<Department> departments = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(employee);
            while (rs.next()){
                departments.add(new Department(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return departments;
    }
}
