package main;

import connector.DbConnector;
import dao.AbstractDao;
import dao.DepartmentDao;

import javax.xml.bind.DataBindingException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Denis on 23.04.2018.
 */
public class Main {

    public static void main(String[] args) {
        DbConnector connector = new DbConnector("jdbc:mysql://localhost/mysql", "root", "root1");
        Connection connection = connector.getConnection();
        AbstractDao dao = new DepartmentDao(connection);
        System.out.println(dao.getAll());

    }
}
