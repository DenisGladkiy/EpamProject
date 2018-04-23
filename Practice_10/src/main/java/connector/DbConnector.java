package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Denis on 23.04.2018.
 */
public class DbConnector {
    private String uri;
    private String user;
    private String password;

    public DbConnector(String uri, String user, String password) {
        this.uri = uri;
        this.user = user;
        this.password = password;
    }

    public Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(uri, user, password);
            System.out.println(connection);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
