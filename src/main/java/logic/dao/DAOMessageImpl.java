package logic.dao;

import logic.connection.AppDataStore;
import logic.dao.rowmapper.MessageRowMapper;
import logic.exceptions.ConnectionException;
import logic.model.Message;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

public class DAOMessageImpl extends JdbcDaoSupport implements DAOInterface<Message> {

    private static final String SELECT_ALL_MESSAGE = "SELECT * FROM message";
    private static final String SELECT_QUERY_BY_SENDREC = "SELECT * FROM message WHERE receiver=? && sender=?";
    private static final String SELECT_QUERY_BY_CHATID = "SELECT * FROM message WHERE chat = ? ORDER BY timestamp DESC";
    private static final String SELECT_QUERY_BY_ID = "SELECT * FROM message WHERE idmessage=?";
    private static final String INSERT_MSG_QUERY = "INSERT INTO message (sender,receiver,text,timestamp,chat) VALUES (?,?,?,?,?)";
    private static final String UPDATE_MSG_QUERY = "UPDATE message SET sender = ?, receiver = ?,text = ?,timestamp = ?, chat = ? WHERE idmessage = ?";
    private static final String DELETE_QUERY = "DELETE FROM message WHERE idmessage=?";

    public DAOMessageImpl() throws ConnectionException {

        this.setDataSource(new AppDataStore().dataSource());
    }

    public List<Message> getBySendRec(long idSend, long idRec){

        assert getJdbcTemplate() != null;
        return  getJdbcTemplate().query(SELECT_QUERY_BY_SENDREC, new MessageRowMapper(), idRec,idSend);
    }

    public List<Message> getAllByChat(long idChat){

        assert getJdbcTemplate() != null;
        return  getJdbcTemplate().query(SELECT_QUERY_BY_CHATID, new MessageRowMapper(), idChat);
    }

    @Override
    public Message get(long id) {
        assert getJdbcTemplate() != null;
        return  getJdbcTemplate().query(SELECT_QUERY_BY_ID, new MessageRowMapper(), id).getFirst();
    }

    @Override
    public List<Message> getAll() {
        assert getJdbcTemplate() != null;
        return  getJdbcTemplate().query(SELECT_ALL_MESSAGE, new MessageRowMapper());

    }

    @Override
    public void save(Message message) {
        assert getJdbcTemplate() != null;
        getJdbcTemplate().update(INSERT_MSG_QUERY, message.getSender(), message.getReceiver(), message.getText(),message.getTime(),message.getIdChat());
    }

    @Override
    public void update(Message message) {

        assert getJdbcTemplate() != null;
        getJdbcTemplate().update(UPDATE_MSG_QUERY, message.getSender(), message.getReceiver(), message.getText(),message.getTime(),message.getIdChat(), message.getIdMsg());
    }


    @Override
    public void delete(Message message) {
        assert getJdbcTemplate() != null;
        getJdbcTemplate().update(DELETE_QUERY, message.getIdMsg());
    }
}
