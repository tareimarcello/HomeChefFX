package logic.dao;

import logic.connection.AppDataStore;
import logic.dao.rowmapper.ChefRowMapper;
import logic.dao.rowmapper.RowLastInsertIdMapper;
import logic.model.Chef;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;
import java.util.Objects;

public class DAOChefImpl extends JdbcDaoSupport implements DAOInterface<Chef> {
    private static final String SELECT_ALL_CHEF = "SELECT * FROM chef";
    private static final String SELECT_QUERY = "SELECT * FROM chef JOIN user ON (chef.iduser=user.iduser) WHERE chef.iduser=?";
    private static final String UPDATE_QUERY = "UPDATE chef SET iduser = ?, restaurant = ?,bestdish = ?, city = ? WHERE iduser=?";
    private static final String DELETE_QUERY = "DELETE FROM chef WHERE iduser=?";
    private static final String SELECT_LAST_INSERT_ID = "SELECT LAST_INSERT_ID()";


    public DAOChefImpl(){

        this.setDataSource(new AppDataStore().dataSource());
    }

    @Override
    public Chef get(long id) {
        assert getJdbcTemplate() != null;
        return  getJdbcTemplate().query(SELECT_QUERY, new ChefRowMapper(), id).getFirst();
    }

    @Override
    public List<Chef> getAll() {

        return  getJdbcTemplate().query(SELECT_ALL_CHEF, new ChefRowMapper());
    }

    @Override
    public void save(Chef chef) {
        assert getJdbcTemplate() != null;
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(Objects.requireNonNull(getDataSource())).withProcedureName("insert_chef");
        MapSqlParameterSource in = new MapSqlParameterSource();
        in.addValue("var_name", chef.getName());
        in.addValue("var_surname", chef.getSurname());
        in.addValue("var_email", chef.getEmail());
        in.addValue("var_passwd", chef.getPassword());
        in.addValue("var_res", chef.getRestaurant());
        in.addValue("var_dish", chef.getBestDish());
        in.addValue("var_citta", chef.getCitta());
        jdbcCall.execute(in);

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

    private Long getLastID (){

        assert getJdbcTemplate() != null;
        return getJdbcTemplate().query(SELECT_LAST_INSERT_ID, new RowLastInsertIdMapper()).getFirst();
    }
}
