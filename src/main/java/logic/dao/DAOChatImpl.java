package logic.dao;

import logic.connection.AppDataStore;
import logic.dao.query.ChatQuery;
import logic.dao.rowmapper.ChatRowMapper;
import logic.exceptions.ConnectionException;
import logic.model.Chat;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

public class DAOChatImpl extends JdbcDaoSupport implements DAOInterface<Chat>{

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

    @Override
    public Chat get(long id) {
        assert getJdbcTemplate() != null;
        return getJdbcTemplate().query(query.selectChat(id), new ChatRowMapper()).getFirst();
    }

    @Override
    public List<Chat> getAll() {
        assert getJdbcTemplate() != null;
        return  getJdbcTemplate().query(query.selectAllChatQuery(), new ChatRowMapper());
    }

    @Override
    public void save(Chat chat) {

        assert getJdbcTemplate() != null;
        getJdbcTemplate().update(query.insertQuery(chat.getChef(), chat.getCustomer()));

    }

    @Override
    public void update(Chat chat) {

        assert getJdbcTemplate() != null;
        getJdbcTemplate().update(query.updateChatQuery(chat.getCustomer(),chat.getChef(),chat.getId()));

    }

    @Override
    public void delete(Chat chat) {

        assert getJdbcTemplate() != null;
        getJdbcTemplate().update(query.deleteQuery(chat.getId()));

    }
}
