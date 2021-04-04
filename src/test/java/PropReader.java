import java.io.FileInputStream;
import java.util.Properties;

public enum PropReader {

    CONFIGURATION( "src/test/resources/info.properties");
    private  Properties properties;
     PropReader(String path){

        try {
           FileInputStream inputStream = new FileInputStream(path);
           properties = new Properties();
           properties.load(inputStream);
        }catch (Exception exception){
            exception.printStackTrace();
        }
    }
    private  String getProperty(String key){
        return  properties.getProperty(key);
    }
    public static String getProperty(PropReader propReader, String key){
        return propReader.getProperty(key);
    }

    public static String getProperty(PropReader propReader, String key, String param){
       return propReader.getProperty(key)+param;
    }

}
