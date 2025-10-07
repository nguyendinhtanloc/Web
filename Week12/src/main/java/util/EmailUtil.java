package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class EmailUtil {
    private static final Properties p;

    static {
        p = new Properties();
        try (InputStream stream = EmailUtil.class.getClassLoader().getResourceAsStream("myemail.properties")) {
            if (stream != null) {
                p.load(stream);
            } else {
                System.out.println("myemail.properties not found!");
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Loading resources error!!!");
        }
    }

    public static String getUser() {
        return p.getProperty("user");
    }

    public static String getPassword() {
        return p.getProperty("password");
    }
}
