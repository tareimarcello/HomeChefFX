package logic.dao;

import logic.connection.AppDataStore;
import logic.model.Message;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

public class DAOMessageImpl extends JdbcDaoSupport implements DAOInterface<Message> {

    private static final String SELECT_ALL_MESSAGE = "SELECT * FROM message";
    private static final String SELECT_QUERY = "SELECT * FROM message WHERE reciver=? && sender=?";
    private static final String SELECT_QUERY_MSG = "SELECT * FROM message WHERE idmessage=?";
    //private static final String SELECT_LAST_QUERY = "SELECT * FROM message WHERE timestamp>all ";
    private static final String INSERT_MSG_QUERY = "INSERT INTO message (sender,receiver,text,timestamp) VALUES (?,?,?,?)";
    private static final String DELETE_QUERY = "DELETE FROM message WHERE idmessage=?";

    public DAOMessageImpl(){

        this.setDataSource(new AppDataStore().dataSource());
    }

    @Override
    public Message get(long id) {
        return null;
    }

    @Override
    public List<Message> getAll() {
        return List.of();
    }

    @Override
    public void save(Message message) {
        assert getJdbcTemplate() != null;
        getJdbcTemplate().update(INSERT_MSG_QUERY, message.getSender(), message.getReceiver(), message.getText(),message.getTime());
    }

    @Override
    public void update(Message message) {

    }


    @Override
    public void delete(Message message) {
        assert getJdbcTemplate() != null;
        getJdbcTemplate().update(DELETE_QUERY, message.getIdMsg());
    }
}
