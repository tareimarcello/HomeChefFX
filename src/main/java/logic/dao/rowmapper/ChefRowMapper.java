package logic.dao.rowmapper;

import logic.model.Chef;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ChefRowMapper implements RowMapper<Chef> {
    @Override
    public Chef mapRow(ResultSet rs, int rowNum) throws SQLException {
        Chef ch=new Chef(
                rs.getInt("iduser"),
                rs.getString("name"),
                rs.getString("surname"),
                rs.getString("email"),
                rs.getString("password"),
                rs.getString("restaurant"),
                rs.getString("bestdish")
        );
        ch.setCitta(rs.getString("city"));
        return ch;
    }
}
