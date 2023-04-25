package util.dataProvider;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

//**************************************************************
//Description: PropertyManager class read global configurations
//and use them during test execution
//**************************************************************
public class PropertyManager {

    private static PropertyManager instance;
    private static final Object lock = new Object();
    private static String propertyFilePath = System.getProperty("user.dir")+
            "//config.properties";
    private  String url;
    private  String browserType;

    //Create a Singleton instance. We need only one instance of Property Manager.
    public static PropertyManager getInstance() {
        if (instance == null) {
            synchronized (lock) {
                instance = new PropertyManager();
                instance.loadData();
            }
        }
        return instance;
    }
    //Get all configuration data and assign to related fields.
    private void loadData() {
        //Declare a properties object
        Properties prop = new Properties();
        //Read configuration.properties file
        try {
            prop.load(new FileInputStream(propertyFilePath));
        } catch (IOException e) {
            System.out.println("Configuration properties file cannot be found");
        }
        //Get properties from config.properties
        url = prop.getProperty("appUrl");
        browserType = prop.getProperty("browserType");
    }
    public String getURL () {
        if(url != null) {
        } else {
            System.out.println("URL not specified");
        }
        return url;
    }
    public String getBrowserType () {
        return browserType;
    }

}
