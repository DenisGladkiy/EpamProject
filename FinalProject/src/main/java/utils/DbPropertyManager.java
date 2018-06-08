package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Denis on 28.04.2018.
 */
public class DbPropertyManager {
    public static final String PROPERTY_FILE = "FinalProject/src/main/resources/dbconfig.properties";
    private FileInputStream fis;
    private Properties property;

    public Properties getProperty(){
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream input = classLoader.getResourceAsStream("dbconfig.properties");
        try {
            property = new Properties();
            property.load(input);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return property;
    }
}
