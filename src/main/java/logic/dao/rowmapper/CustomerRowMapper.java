package logic.dao.rowmapper;

import logic.model.Customer;
import logic.patterns.factory.FactoryUser;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerRowMapper implements RowMapper<Customer> {
    @Override
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
        FactoryUser factory = new FactoryUser();
        return factory.createCustomer(rs.getInt("iduser"),
                rs.getString("name"),
                rs.getString("surname"),
                rs.getBoolean("bookNot"));
    }
}
