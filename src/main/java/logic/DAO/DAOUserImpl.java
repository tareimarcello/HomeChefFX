package logic.DAO;

import logic.connection.AppDataStore;
import model.Chef;
import model.Customer;
import model.User;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class DAOUserImpl extends JdbcDaoSupport implements DAOInterface<User> {

    private static final String SELECT_QUERY = "SELECT * FROM user WHERE iduser=?";
    private static final String INSERT_QUERY = "INSERT INTO user (iduser, name, surname,email,password) VALUES (?,?,?,?,?)";
    private static final String UPDATE_QUERY = "UPDATE user SET iduser = ?, name = ?,surname = ?, email = ?, password = ? WHERE iduser=?";
    private static final String DELETE_QUERY = "DELETE FROM user WHERE iduser=?";

    //private JdbcTemplate jdbcTemplate;

    public DAOUserImpl(){

      setDataSource(new AppDataStore().dataSource());

    }

    @Override
    public User get(long id) {
        assert getJdbcTemplate() != null;

        return getJdbcTemplate().query(SELECT_QUERY, new FootballPlayerRowMapper(), id).getFirst();
    }

    @Override
    public List<User> getAll() {
        assert getJdbcTemplate() != null;
        return getJdbcTemplate().query(SELECT_ALL_QUERY, new FootballPlayerRowMapper(), "1");
    }

    @Override
    public void save(User user) {
        assert getJdbcTemplate() != null;
        getJdbcTemplate().update(INSERT_QUERY, user.getId(), user.getRole(),
                user.getMantraRole(),user.getName(),user.getTeam(),"1",user.getTeamLega(),footballPlayer.get);
    }

    @Override
    public void update(User footballPlayer) {
        assert getJdbcTemplate() != null;
        getJdbcTemplate().update(UPDATE_QUERY,  footballPlayer.getRole().toString(),
                footballPlayer.getMantraRole(),footballPlayer.getName(),footballPlayer.getTeam(),"1",footballPlayer.getTeamLega(),footballPlayer.getId());
    }

    @Override
    public void delete(User footballPlayer) {
        assert getJdbcTemplate() != null;
        getJdbcTemplate().update(DELETE_QUERY, footballPlayer.getId());
    }

}
