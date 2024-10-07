package logic.connection;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

    private Properties properties;

    private static final String Config_File_Path= "src/main/java/db.properties";


    public ConfigFileReader() {


        File configFile=new File(Config_File_Path);


        try {

            FileInputStream configFileReader=new FileInputStream(configFile);

            properties = new Properties();


            try {

                properties.load(configFileReader);

                configFileReader.close();

            } catch (IOException e)

            {

                System.out.println(e.getMessage());

            }

        }  catch (FileNotFoundException e)

        {

            System.out.println(e.getMessage());

            throw new RuntimeException("config.properties not found at config file path " + Config_File_Path);

        }

    }

    public String getPropertyValue(String property){

        String value = properties.getProperty(property);
        if (value!=null)
            return value;

        else
            throw new RuntimeException("Application property not specified in the config.properties file.");

    }
}
