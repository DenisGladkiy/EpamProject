package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Denis on 28.04.2018.
 */
public class DbPropertyManager {
    public static final String PROPERTY_FILE = "FinalProject/src/main/resources/dbconfig.properties";
    private FileInputStream fis;
    private Properties property;

    public Properties getProperty(){
        try {
            fis = new FileInputStream(PROPERTY_FILE);
            property = new Properties();
            property.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return property;
    }
}
