package main;

import connector.DbConnector;
import dao.AbstractDao;
import dao.DepartmentDao;
import dao.EmployeeDao;
import dao.TaskDao;

import java.sql.Connection;

/**
 * Created by Denis on 23.04.2018.
 */
public class Main {

    public static void main(String[] args) {
        DbConnector connector = new DbConnector("jdbc:mysql://localhost/mysql", "root", "root1");
        Connection connection = connector.getConnection();
        AbstractDao depDao = new DepartmentDao(connection);
        AbstractDao empDao = new EmployeeDao(connection);
        AbstractDao taskDao = new TaskDao(connection);
        System.out.println(empDao.getAll());
        System.out.println(taskDao.getAll());
        System.out.println("By dep " + empDao.getByForeignKey(2));
        System.out.println(taskDao.getByForeignKey(1));


    }
}
