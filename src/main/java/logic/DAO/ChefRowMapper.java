package logic.DAO;

import logic.model.Chef;
import logic.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ChefRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Chef(
                rs.getInt("iduser"),
                rs.getString("name"),
                rs.getString("surname"),
                rs.getString("email"),
                rs.getString("password"),
                rs.getString("restaurant"),
                rs.getString("bestdish"),
                rs.getString("citta")
        );
    }
}
