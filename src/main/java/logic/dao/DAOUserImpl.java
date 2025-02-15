package logic.dao;


import logic.beans.EditProfileBean;
import logic.connection.AppDataStore;
import logic.dao.query.UserQuery;
import logic.exceptions.ConnectionException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOUserImpl extends JdbcDaoSupport {

    private final UserQuery query;

    public DAOUserImpl() throws ConnectionException {
        this.setDataSource(new AppDataStore().dataSource());
        query = new UserQuery();
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

    public String getPswd(long id){
        assert getJdbcTemplate() != null;
        return getJdbcTemplate().queryForObject(query.selectPswdQuery(id),String.class);
    }

    public long getId(String email, String pswd){
        assert getJdbcTemplate() != null;
        return getJdbcTemplate().queryForObject(query.selectIdUsers(email, pswd),long.class);
    }


}
