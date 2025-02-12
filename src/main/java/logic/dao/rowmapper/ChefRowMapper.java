package logic.dao.rowmapper;

import logic.model.Chef;
import logic.patterns.factory.FactoryUser;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ChefRowMapper implements RowMapper<Chef> {
    @Override
    public Chef mapRow(ResultSet rs, int rowNum) throws SQLException {
        FactoryUser factory = new FactoryUser();
        return factory.createChef(rs.getInt("iduser"),
                rs.getString("name"),
                rs.getString("surname"),
                rs.getString("restaurant"),
                rs.getString("bestdish"),
                rs.getString("city"));
    }
}
