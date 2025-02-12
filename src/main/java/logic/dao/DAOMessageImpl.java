package logic.dao;

import logic.connection.AppDataStore;
import logic.dao.query.MessageQuery;
import logic.dao.rowmapper.MessageRowMapper;
import logic.exceptions.ConnectionException;
import logic.model.Message;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

public class DAOMessageImpl extends JdbcDaoSupport {


    private final MessageQuery query;

    public DAOMessageImpl() throws ConnectionException {

        this.setDataSource(new AppDataStore().dataSource());
        query=new MessageQuery();
    }

    public List<Message> getAllByChat(long idChat){

        assert getJdbcTemplate() != null;
        return  getJdbcTemplate().query(query.getSelectByChatId(idChat), new MessageRowMapper());
    }

    public void save(Message message) {
        assert getJdbcTemplate() != null;
        getJdbcTemplate().update(query.insertMessageQuery(message.getSender(), message.getReceiver(), message.getText(),message.getIdChat()));
    }
}
