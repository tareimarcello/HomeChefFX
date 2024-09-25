package logic.connection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.Objects;

@Configuration
@ComponentScan("simonetutor.projects.fantaastamanager")
@PropertySource("classpath:database.properties")
public class AppDataStore {

    private static final ConfigFileReader reader = new ConfigFileReader();

    private final String CONNECTION_URL = "url";
    private final String LOGIN_USER = "dbuser";
    private final String DRIVER_CLASS_NAME = "driver";
    private final String LOGIN_PASS = "dbpassword";

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
