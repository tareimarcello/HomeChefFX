package logic.connection;

import logic.exceptions.ConnectionException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

public class ConfigFileReader {

    private Properties properties;

    private static final String CONFIG_FILE_PATH= "src/main/java/db.properties";
    private Logger logger = Logger.getLogger(getClass().getName());


    public ConfigFileReader() throws ConnectionException {


        File configFile=new File(CONFIG_FILE_PATH);


        try {

            FileInputStream configFileReader=new FileInputStream(configFile);

            properties = new Properties();



                properties.load(configFileReader);

                configFileReader.close();


        }  catch (FileNotFoundException e)

        {

            throw new ConnectionException("config.properties not found at config file path " + CONFIG_FILE_PATH);

        }catch (IOException e)

        {

            logger.info(e.getMessage());

        }

    }

    public String getPropertyValue(String property) throws ConnectionException {

        String value = properties.getProperty(property);
        if (value!=null)
            return value;

        else
            throw new ConnectionException("Application property not specified in the config.properties file.");

    }
}
