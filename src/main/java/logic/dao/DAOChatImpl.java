package logic.dao;

import logic.connection.AppDataStore;
import logic.dao.rowmapper.ChatRowMapper;
import logic.dao.rowmapper.MessageRowMapper;
import logic.model.Chat;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

public class DAOChatImpl extends JdbcDaoSupport implements DAOInterface<Chat>{

    private static final String SELECT_ALL_CHAT = "SELECT * FROM chat";
    private static final String SELECT_QUERY_BY_CUST= "SELECT * FROM chat WHERE customer=?";
    private static final String SELECT_QUERY_BY_CHEF= "SELECT * FROM chat WHERE chef=?";
    private static final String SELECT_QUERY_BY_ID = "SELECT * FROM chat WHERE idchat=?";
    private static final String INSERT_CHAT_QUERY = "INSERT INTO chat (customer,chef) VALUES (?,?)";
    private static final String UPDATE_CHAT_QUERY = "UPDATE chat SET customer = ?,chef = ?  WHERE idchat = ?";
    private static final String DELETE_QUERY = "DELETE FROM chat WHERE idchat=?";

    public DAOChatImpl() {

        this.setDataSource(new AppDataStore().dataSource());
    }

    public List<Chat> getAllChatByCust(long idCustomer){

        assert getJdbcTemplate() != null;
        return getJdbcTemplate().query(SELECT_QUERY_BY_CUST, new ChatRowMapper(), idCustomer);
    }

    public List<Chat> getAllChatByChef(long idChef){

        assert getJdbcTemplate() != null;
        return getJdbcTemplate().query(SELECT_QUERY_BY_CHEF, new ChatRowMapper(),idChef);
    }

    @Override
    public Chat get(long id) {
        assert getJdbcTemplate() != null;
        return getJdbcTemplate().query(SELECT_QUERY_BY_ID, new ChatRowMapper(), id).getFirst();
    }

    @Override
    public List<Chat> getAll() {
        assert getJdbcTemplate() != null;
        return  getJdbcTemplate().query(SELECT_ALL_CHAT, new ChatRowMapper());
    }

    @Override
    public void save(Chat chat) {

        assert getJdbcTemplate() != null;
        getJdbcTemplate().update(INSERT_CHAT_QUERY, chat.getCustomer(),chat.getChef());

    }

    @Override
    public void update(Chat chat) {

        assert getJdbcTemplate() != null;
        getJdbcTemplate().update(UPDATE_CHAT_QUERY, chat.getCustomer(),chat.getChef(),chat.getId());

    }

    @Override
    public void delete(Chat chat) {

        assert getJdbcTemplate() != null;
        getJdbcTemplate().update(DELETE_QUERY, chat.getId());

    }
}
