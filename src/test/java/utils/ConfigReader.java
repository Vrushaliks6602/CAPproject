package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;
    private static final String PROPERTY_FILE_PATH = "src/test/resources/config/config.properties";

    static {
        try {
            properties = new Properties();
            FileInputStream fis = new FileInputStream(PROPERTY_FILE_PATH);
            properties.load(fis);
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}