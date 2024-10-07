package logic.connection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.Objects;

@Configuration
public class AppDataStore {

    private static final ConfigFileReader reader = new ConfigFileReader();

    private final String connectionUrl = "CONNECTION_URL";
    private final String loginUser = "LOGIN_USER";
    private final String driverClassName = "DRIVER_CLASS_NAME";
    private final String loginPass = "LOGIN_PASS";

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setUrl(reader.getPropertyValue(connectionUrl));
        driverManagerDataSource.setUsername(reader.getPropertyValue(loginUser));
        driverManagerDataSource.setPassword(reader.getPropertyValue(loginPass));
        driverManagerDataSource.setDriverClassName(Objects.requireNonNull(reader.getPropertyValue(driverClassName)));
        return driverManagerDataSource;
    }
}
