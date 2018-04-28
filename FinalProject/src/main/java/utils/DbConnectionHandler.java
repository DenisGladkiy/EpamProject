package utils;

import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by Denis on 28.04.2018.
 */
public class DbConnectionHandler {
    private static volatile DataSource dataSource;
    private DbPropertyManager dpm;
    private static Properties properties;

    public DbConnectionHandler(){
        dpm = new DbPropertyManager();
        properties = dpm.getProperty();
    }

    private static DataSource getDataSource(){
        if(dataSource == null){
            synchronized (DbConnectionHandler.class){
                if(dataSource == null){
                    BasicDataSource ds = new BasicDataSource();
                    ds.setDriverClassName(properties.getProperty("db.driver"));
                    ds.setUrl(properties.getProperty("db.url"));
                    ds.setUsername(properties.getProperty("db.login"));
                    ds.setPassword(properties.getProperty("db.password"));
                    ds.setMinIdle(Integer.valueOf(properties.getProperty("db.min.idle")));
                    ds.setMaxIdle(Integer.valueOf(properties.getProperty("db.max.idle")));
                    ds.setMaxOpenPreparedStatements(Integer.valueOf(properties.getProperty("db.max.open.prepare.statements")));
                    dataSource = ds;
                }
            }
        }
        return dataSource;
    }

    public Connection getConnection(){
        try {
            return getDataSource().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
