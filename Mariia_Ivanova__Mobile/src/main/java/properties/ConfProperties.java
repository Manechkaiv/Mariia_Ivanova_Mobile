package properties;

import setup.BaseTest;

import java.io.IOException;

import java.io.InputStream;
import java.util.Properties;

public class ConfProperties {

    private static Properties PROPERTIES;

        static {
            PROPERTIES = new Properties();
            try (InputStream inputStream = BaseTest.class.getClassLoader()
                    .getResourceAsStream("config.properties")) {
                PROPERTIES.load(inputStream);
            } catch (IOException e) {
                System.out.println(e);
            }
        }

    private ConfProperties() {}

    public static String getProperty(String key) {
        return PROPERTIES.getProperty(key);
    }
}

