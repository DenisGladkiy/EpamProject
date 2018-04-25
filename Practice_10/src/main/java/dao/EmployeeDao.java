package dao;

import dao.entity.Employee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
       String query = "SELECT * FROM EMPLOYEE";
       return getEmployee(query);
    }

    @Override
    public List<Employee> getByForeignKey(int depNumber) {
        String query = "SELECT * FROM EMPLOYEE WHERE DEPNUMBER=" + depNumber;
        return getEmployee(query);
    }

    @Override
    public Employee getById(int primaryKey) {
        return null;
    }

    @Override
    public void addByForeignKey(int key) {
    }

    @Override
    public void removeById(int primaryKey) {
        String query = "delete from employee where Employee.number=" + primaryKey;
        try (Statement statement = connection.createStatement()){
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private List<Employee> getEmployee(String query){
        ArrayList<Employee> employees = new ArrayList<>();
        try(Statement statement = connection.createStatement();
                    ResultSet rs = statement.executeQuery(query)) {
            while (rs.next()){
                employees.add(new Employee(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }
}
