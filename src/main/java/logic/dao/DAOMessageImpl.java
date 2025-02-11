package logic.dao;

import logic.connection.AppDataStore;
import logic.dao.query.MessageQuery;
import logic.dao.rowmapper.MessageRowMapper;
import logic.exceptions.ConnectionException;
import logic.model.Message;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

public class DAOMessageImpl extends JdbcDaoSupport implements DAOInterface<Message> {

    private static final String UPDATE_MSG_QUERY = "UPDATE message SET sender = ?, receiver = ?,text = ?,timestamp = ?, chat = ? WHERE idmessage = ?";
    private static final String DELETE_QUERY = "DELETE FROM message WHERE idmessage=?";

    private final MessageQuery query;

    public DAOMessageImpl() throws ConnectionException {

        this.setDataSource(new AppDataStore().dataSource());
        query=new MessageQuery();
    }


    public List<Message> getAllByChat(long idChat){

        assert getJdbcTemplate() != null;
        return  getJdbcTemplate().query(query.getSelectByChatId(idChat), new MessageRowMapper());
    }

    @Override
    public Message get(long id) {
        assert getJdbcTemplate() != null;
        return  getJdbcTemplate().query(query.getSelectMessageById(id), new MessageRowMapper()).getFirst();
    }

    @Override
    public List<Message> getAll() {
        assert getJdbcTemplate() != null;
        return  getJdbcTemplate().query(query.getSelectAllMessage(), new MessageRowMapper());

    }

    @Override
    public void save(Message message) {
        assert getJdbcTemplate() != null;
        getJdbcTemplate().update(query.insertMessageQuery(message.getSender(), message.getReceiver(), message.getText(),message.getIdChat()));
    }

    @Override
    public void update(Message message) {

        assert getJdbcTemplate() != null;
        getJdbcTemplate().update(query.updateQuery(message.getSender(), message.getReceiver(), message.getText(),message.getIdChat(), message.getIdMsg()));
    }


    @Override
    public void delete(Message message) {
        assert getJdbcTemplate() != null;
        getJdbcTemplate().update(query.deleteQuery(message.getIdMsg()));
    }
}
