package logic.connection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.Objects;

@Configuration
public class AppDataStore {

    private static final ConfigFileReader reader = new ConfigFileReader();

    private static final String CONNECTION_URL = "CONNECTION_URL";
    private static final String LOGIN_USER = "LOGIN_USER";
    private static final String DRIVER_CLASS_NAME = "DRIVER_CLASS_NAME";
    private static final String LOGIN_PASS = "LOGIN_PASS";

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setUrl(reader.getPropertyValue(CONNECTION_URL));
        driverManagerDataSource.setUsername(reader.getPropertyValue(LOGIN_USER));
        driverManagerDataSource.setPassword(reader.getPropertyValue(LOGIN_PASS));
        driverManagerDataSource.setDriverClassName(Objects.requireNonNull(reader.getPropertyValue(DRIVER_CLASS_NAME)));
        return driverManagerDataSource;
    }
}
