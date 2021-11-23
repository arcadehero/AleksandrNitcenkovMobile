package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {

    public static String getProperty(String property) {
        Properties properties = new Properties();
        try (FileInputStream inputStream = new FileInputStream("src/test/resources/native_test.properties")) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty(property);
    }
}
