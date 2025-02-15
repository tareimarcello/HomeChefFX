package logic.dao.rowmapper;

import logic.model.User;
import logic.patterns.factory.FactoryUser;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        FactoryUser factory = new FactoryUser();
        return factory.createCustomer(rs.getInt("iduser"),
                rs.getString("name"),
                rs.getString("surname"),
                rs.getBoolean("bookNot"));
    }
}
