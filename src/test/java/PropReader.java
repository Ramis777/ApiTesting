import java.io.FileInputStream;
import java.util.Properties;

public class PropReader {
    private  static Properties properties;
    static {
        String path = "src/test/resources/info.properties";
        try {
           FileInputStream inputStream = new FileInputStream(path);
           properties = new Properties();
           properties.load(inputStream);
        }catch (Exception exception){
            exception.printStackTrace();
        }
    }
    public static String getProperty(String key){
        return  properties.getProperty(key);
    }
}
