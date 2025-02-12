package logic.dao;

import logic.connection.AppDataStore;
import logic.dao.query.ChatQuery;
import logic.dao.rowmapper.ChatRowMapper;
import logic.exceptions.ConnectionException;
import logic.model.Chat;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

public class DAOChatImpl extends JdbcDaoSupport{

    private final ChatQuery query;

    public DAOChatImpl() throws ConnectionException {
            this.setDataSource(new AppDataStore().dataSource());
            query=new ChatQuery();
    }

    public List<Chat> getAllChatByCust(long idCustomer){

        assert getJdbcTemplate() != null;
        return getJdbcTemplate().query(query.selectQueryByCustomer(idCustomer), new ChatRowMapper());
    }

    public List<Chat> getChatByCustChef(long idCustomer, long idChef){

        assert getJdbcTemplate() != null;
        return getJdbcTemplate().query(query.getSelectChatByChefcust(idCustomer,idChef), new ChatRowMapper());
    }


    public List<Chat> getAllChatByChef(long idChef){

        assert getJdbcTemplate() != null;
        return getJdbcTemplate().query(query.selectQueryByChef(idChef), new ChatRowMapper());
    }


    public void save(Chat chat) {

        assert getJdbcTemplate() != null;
        getJdbcTemplate().update(query.insertQuery(chat.getChef(), chat.getCustomer()));

    }

}
