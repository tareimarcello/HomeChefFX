package logic.dao.rowmapper;

import logic.model.Chat;
import logic.model.Message;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ChatRowMapper implements RowMapper<Chat> {



    @Override
    public Chat mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Chat(
                rs.getInt("idchat"),
                rs.getInt("customer"),
                rs.getInt("chef")
        );
    }
}
