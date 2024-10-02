package logic.dao;


import logic.beans.Logbean;
import logic.connection.AppDataStore;
import logic.dao.rowmapper.UserRowMapper;
import logic.model.User;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

public class DAOUserImpl extends JdbcDaoSupport implements DAOInterface<User> {

    private static final String SELECT_USER_BY_EMAIL = "SELECT * FROM user WHERE email = ?";

    public DAOUserImpl(){

        this.setDataSource(new AppDataStore().dataSource());
    }

    @Override
    public User get(long id) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return List.of();
    }

    @Override
    public void save(User user) {

    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(User user) {

    }

    public User verifyLogin(Logbean logBean){

        assert getJdbcTemplate() != null;
        return getJdbcTemplate().query(SELECT_USER_BY_EMAIL, new UserRowMapper(), logBean.getEmail()).getFirst();

    }
}
