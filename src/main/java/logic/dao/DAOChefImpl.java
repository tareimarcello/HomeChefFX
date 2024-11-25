package logic.dao;

import logic.beans.SearchBean;
import logic.connection.AppDataStore;
import logic.dao.rowmapper.ChefRowMapper;
import logic.exceptions.ConnectionException;
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


    public DAOChefImpl() throws ConnectionException {

        this.setDataSource(new AppDataStore().dataSource());
    }

    @Override
    public Chef get(long id) {
        assert getJdbcTemplate() != null;
        return  getJdbcTemplate().query(SELECT_QUERY, new ChefRowMapper(), id).getFirst();
    }

    @Override
    public List<Chef> getAll() {

        assert getJdbcTemplate() != null;
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
                chef.getBestDish(),chef.getCitta(), chef.getID());
    }

    @Override
    public void delete(Chef chef) {
        assert getJdbcTemplate() != null;
        getJdbcTemplate().update(DELETE_QUERY, chef.getID());
    }


    public List<Chef> getChefByParam(SearchBean searchParam) {

        assert getJdbcTemplate() != null;
        StringBuilder query = new StringBuilder();
        boolean first = true;
        String condKey = "WHERE";
        String condition = "";
        query.append ("SELECT * FROM chef JOIN user ON (chef.iduser=user.iduser)");
        if (searchParam.getChefName()!= null && !searchParam.getChefName().equals("")){
            condition = "surname = '"+searchParam.getChefName()+"'";

            query.append(" ").append(condKey).append(" ").append(condition);

            first = false;
        }

        if (searchParam.getChefCity()!= null && !searchParam.getChefCity().equals("")){
            if (!first) condKey = "AND";
            else
                first = false;

            condition = "city = '"+searchParam.getChefCity()+"'";
            query.append(" ").append(condKey).append(" ").append(condition);


        }

        if (searchParam.getChefBestDish()!= null && !searchParam.getChefBestDish().equals("")){
            if (!first) condKey = "AND";
            else
                first = false;

            condition = "bestdish = '"+searchParam.getChefBestDish()+"'";
            query.append(" ").append(condKey).append(" ").append(condition);


        }
        return  getJdbcTemplate().query(query.toString(), new ChefRowMapper());
    }



}
