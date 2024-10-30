package logic.dao.rowmapper;

import logic.model.Message;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MessageRowMapper implements RowMapper<Message> {

    @Override
    public Message mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Message(
                rs.getInt("idmessage"),
                rs.getInt("sender"),
                rs.getInt("receiver"),
                rs.getString("text"),
                rs.getTimestamp("timestamp"),
                rs.getInt("chat")
        );
    }
}
