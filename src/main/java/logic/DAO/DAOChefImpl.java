package logic.DAO;

import logic.model.Chef;
import logic.model.Customer;
import logic.model.User;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

public class DAOChefImpl extends JdbcDaoSupport implements DAOInterface<Chef> {
    private static final String SELECT_ALL_CHEF = "SELECT * FROM chef";
    private static final String SELECT_QUERY = "SELECT * FROM chef WHERE iduser=?";
    private static final String INSERT_QUERY = "INSERT INTO chef (iduser,restaurant,bestdish,city) VALUES (?,?,?,?)";
    private static final String UPDATE_QUERY = "UPDATE chef SET iduser = ?, restaurant = ?,bestdish = ?, city = ? WHERE iduser=?";
    private static final String DELETE_QUERY = "DELETE FROM chef WHERE iduser=?";

    @Override
    public Chef get(long id) {
        assert getJdbcTemplate() != null;
        return (Chef) getJdbcTemplate().query(SELECT_QUERY, new ChefRowMapper(), id).getFirst();
    }

    @Override
    public List<Chef> getAll() {
        return List.of();
    }

    @Override
    public void save(Chef chef) {
        assert getJdbcTemplate() != null;
        getJdbcTemplate().update(INSERT_QUERY, chef.getID(), chef.getRestaurant(),
                chef.getBestDish(),chef.getCitta());

    }

    @Override
    public void update(Chef chef) {
        assert getJdbcTemplate() != null;
        getJdbcTemplate().update(UPDATE_QUERY,  chef.getID(), chef.getRestaurant(),
                chef.getBestDish(),chef.getCitta());
    }

    @Override
    public void delete(Chef chef) {
        assert getJdbcTemplate() != null;
        getJdbcTemplate().update(DELETE_QUERY, chef.getID());
    }
}
