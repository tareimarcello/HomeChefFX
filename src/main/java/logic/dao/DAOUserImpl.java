package logic.dao;


import logic.beans.Logbean;
import logic.beans.EditProfileBean;
import logic.connection.AppDataStore;
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

    private static final String SELECT_USER_BY_EMAIL = "SELECT * FROM user WHERE email = ?";
    private static final String SELECT_USER_BY_ID = "SELECT * FROM user WHERE iduser = ?";
    private static final String UPDATE_PSWD_BY_ID = "UPDATE user SET password = ? WHERE iduser = ?";
    private static final String UPDATE_EMAIL_BY_ID = "UPDATE user SET email = ? WHERE iduser = ?";
    private static final String SELECT_LIST_MAIL =  "SELECT email FROM user";


    public DAOUserImpl() throws ConnectionException {

        this.setDataSource(new AppDataStore().dataSource());
    }

    @Override
    public User get(long id) {

        assert getJdbcTemplate() != null;
        return getJdbcTemplate().query(SELECT_USER_BY_ID, new UserRowMapper(), id).getFirst();

    }

    @Override
    public List<User> getAll() {
        return List.of();
    }

    @Override
    public void save(User user) {
        //to be implemented
    }

    @Override
    public void update(User user) {
        //to be implemented
    }

    @Override
    public void delete(User user) {
        //to be implemented
    }

    public User verifyLogin(Logbean logBean){

        assert getJdbcTemplate() != null;
        return getJdbcTemplate().query(SELECT_USER_BY_EMAIL, new UserRowMapper(), logBean.getEmail()).getFirst();

    }

    public void updatePswd(EditProfileBean updatePswdBean){
        assert getJdbcTemplate() != null;
        getJdbcTemplate().update(UPDATE_PSWD_BY_ID, updatePswdBean.getPswd(),updatePswdBean.getUserId());
    }

    public void updateMail(EditProfileBean updateMailBean){
        assert getJdbcTemplate() != null;
        getJdbcTemplate().update(UPDATE_EMAIL_BY_ID, updateMailBean.getEmail(),updateMailBean.getUserId());
    }

    public List<String> getUsersMail(){
        assert getJdbcTemplate() != null;
        return getJdbcTemplate().query(SELECT_LIST_MAIL, new ResultSetExtractor<List<String>>(){
            public List<String> extractData(ResultSet rs) throws SQLException, DataAccessException {
                List<String> mailDetailList = new ArrayList<String>();
                String mail;
                while(rs.next()) {
                    mail=(rs.getString(1));
                    mailDetailList.add(mail);
                }
                return mailDetailList;
            }
        });
    }
}
