package logic.connection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.Objects;

@Configuration
public class AppDataStore {

    private static final ConfigFileReader reader = new ConfigFileReader();

    private final String connection_url = "CONNECTION_URL";
    private final String login_user = "LOGIN_USER";
    private final String driver_class_name = "DRIVER_CLASS_NAME";
    private final String login_pass = "LOGIN_PASS";

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setUrl(reader.getPropertyValue(connection_url));
        driverManagerDataSource.setUsername(reader.getPropertyValue(login_user));
        driverManagerDataSource.setPassword(reader.getPropertyValue(login_pass));
        driverManagerDataSource.setDriverClassName(Objects.requireNonNull(reader.getPropertyValue(driver_class_name)));
        return driverManagerDataSource;
    }
}
