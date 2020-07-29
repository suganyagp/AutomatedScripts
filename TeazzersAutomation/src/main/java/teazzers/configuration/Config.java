package teazzers.configuration;

import java.io.FileInputStream;
import java.util.Properties;

public class Config {

    private static Properties defaultProps = new Properties();
    static {
        try {
            FileInputStream in = new FileInputStream("C:\\Users\\suganyap\\Desktop\\Automation\\Teazzers\\TeazzersAutomation\\Configs\\config.properties");
            defaultProps.load(in);
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return defaultProps.getProperty(key);
    }
}