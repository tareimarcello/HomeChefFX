package logic.dao;

import logic.beans.SearchBean;
import logic.connection.AppDataStore;
import logic.dao.query.ChefQuery;
import logic.dao.rowmapper.ChefRowMapper;
import logic.exceptions.ConnectionException;
import logic.model.Chef;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;
import java.util.Objects;

public class DAOChefImpl extends JdbcDaoSupport implements DAOInterface<Chef> {

    private final ChefQuery query;

    public DAOChefImpl() throws ConnectionException {

        this.setDataSource(new AppDataStore().dataSource());
        query = new ChefQuery();
    }

    @Override
    public Chef get(long id) {
        assert getJdbcTemplate() != null;
        return  getJdbcTemplate().query(query.selectChefQuery(id), new ChefRowMapper()).getFirst();
    }

    @Override
    public List<Chef> getAll() {

        assert getJdbcTemplate() != null;
        return  getJdbcTemplate().query(query.selectAllChefQuery(), new ChefRowMapper());
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
        getJdbcTemplate().update(query.updateChefQuery(chef.getID(), chef.getRestaurant(),
                        chef.getBestDish(),chef.getCitta()));
    }

    @Override
    public void delete(Chef chef) {
        assert getJdbcTemplate() != null;
        getJdbcTemplate().update(query.deleteChefQuery(chef.getID()));
    }


    public List<Chef> getChefByParam(SearchBean searchParam) {

        assert getJdbcTemplate() != null;
        return  getJdbcTemplate().query(query.getChefBYParamQuery(searchParam), new ChefRowMapper());
    }
}
