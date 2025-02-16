package logic.dao;

import logic.beans.SearchBean;
import logic.connection.AppDataStore;
import logic.dao.query.ChefQuery;
import logic.dao.rowmapper.ChefRowMapper;
import logic.exceptions.ConnectionException;
import logic.model.User;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;
import java.util.Objects;

public class DAOChefImpl extends JdbcDaoSupport {

    private final ChefQuery query;

    public DAOChefImpl() throws ConnectionException {

        this.setDataSource(new AppDataStore().dataSource());
        query = new ChefQuery();
    }


    public User get(long id) {
        assert getJdbcTemplate() != null;
        return  getJdbcTemplate().query(query.selectChefQuery(id), new ChefRowMapper()).getFirst();
    }


    public void save(String name,String surname, String res,String bestDish, String citta, String email, String password) {
        assert getJdbcTemplate() != null;
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(Objects.requireNonNull(getDataSource())).withProcedureName("insert_chef");
        MapSqlParameterSource in = new MapSqlParameterSource();
        in.addValue("var_name", name);
        in.addValue("var_surname", surname);
        in.addValue("var_email", email);
        in.addValue("var_passwd", password);
        in.addValue("var_res", res);
        in.addValue("var_dish", bestDish);
        in.addValue("var_citta", citta);
        jdbcCall.execute(in);

    }


    public void update(User chef) {
        assert getJdbcTemplate() != null;
        getJdbcTemplate().update(query.updateChefQuery(chef.getID(), (String) chef.getInfo(0),
                (String) chef.getInfo(1), (String) chef.getInfo(2)));
    }


    public List<User> getChefByParam(SearchBean searchParam) {

        assert getJdbcTemplate() != null;
        return  getJdbcTemplate().query(query.getChefBYParamQuery(searchParam), new ChefRowMapper());
    }
}
