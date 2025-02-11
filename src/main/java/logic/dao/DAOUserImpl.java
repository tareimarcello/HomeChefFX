package logic.dao;


import logic.beans.Logbean;
import logic.beans.EditProfileBean;
import logic.connection.AppDataStore;
import logic.dao.query.UserQuery;
import logic.dao.rowmapper.UserRowMapper;
import logic.exceptions.ConnectionException;
import logic.model.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOUserImpl extends JdbcDaoSupport implements DAOInterface<User> {

    private final UserQuery query;

    public DAOUserImpl() throws ConnectionException {
        this.setDataSource(new AppDataStore().dataSource());
        query = new UserQuery();
    }

    @Override
    public User get(long id) {

        assert getJdbcTemplate() != null;
        return getJdbcTemplate().query(query.selectUserById(id), new UserRowMapper()).getFirst();

    }

    @Override
    public List<User> getAll() {
        assert getJdbcTemplate() != null;
        return  getJdbcTemplate().query(query.selectAllUserQuery(), new UserRowMapper());
    }

    @Override
    public void save(User user) {
        assert getJdbcTemplate() != null;
        getJdbcTemplate().update(query.insertQuery(user.getName(),user.getSurname(),user.getEmail(),user.getPassword(),user.getID()));
    }

    @Override
    public void update(User user) {
        assert getJdbcTemplate() != null;
        getJdbcTemplate().update(query.updateQuery(user.getEmail(),user.getPassword(), user.getID()));
    }

    @Override
    public void delete(User user) {
        assert getJdbcTemplate() != null;
        getJdbcTemplate().update(query.deleteQuery(user.getID()));
    }

    public User verifyLogin(Logbean logBean){

        assert getJdbcTemplate() != null;
        return getJdbcTemplate().query(query.selectUserByEmailQuery(logBean.getEmail()), new UserRowMapper()).getFirst();

    }

    public void updatePswd(EditProfileBean updatePswdBean){
        assert getJdbcTemplate() != null;
        getJdbcTemplate().update(query.updatePswdById(updatePswdBean.getPswd(),updatePswdBean.getUserId()));
    }

    public void updateMail(EditProfileBean updateMailBean){
        assert getJdbcTemplate() != null;
        getJdbcTemplate().update(query.updateEmailByIdQuery(updateMailBean.getEmail(),updateMailBean.getUserId()));
    }

    public List<String> getUsersMail(){
        assert getJdbcTemplate() != null;
        return getJdbcTemplate().query(query.selectListMailQuery(), new ResultSetExtractor<List<String>>(){
            public List<String> extractData(ResultSet rs) throws SQLException, DataAccessException {
                List<String> mailDetailList = new ArrayList<>();
                String mail;
                while(rs.next()) {
                    mail=(rs.getString(1));
                    mailDetailList.add(mail);
                }
                return mailDetailList;
            }
        });
    }
    public User getUserBYMail(String mail){
        assert getJdbcTemplate() != null;
        return getJdbcTemplate().query(query.selectUserByEmailQuery(mail), new UserRowMapper()).getFirst();
    }


}
