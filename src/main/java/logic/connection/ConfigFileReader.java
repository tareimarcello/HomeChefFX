package logic.connection;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

    private Properties properties;

    private static final String CONFIG_FILE_PATH= "src/main/java/db.properties";


    public ConfigFileReader() {


        File configFile=new File(CONFIG_FILE_PATH);


        try {

            FileInputStream configFileReader=new FileInputStream(configFile);

            properties = new Properties();



                properties.load(configFileReader);

                configFileReader.close();


        }  catch (FileNotFoundException e)

        {

            throw new RuntimeException("config.properties not found at config file path " + CONFIG_FILE_PATH);

        }catch (IOException e)

        {

            System.out.println(e.getMessage());

        }

    }

    public String getPropertyValue(String property) throws Exception {

        String value = properties.getProperty(property);
        if (value!=null)
            return value;

        else
            throw new Exception("Application property not specified in the config.properties file.");

    }
}
