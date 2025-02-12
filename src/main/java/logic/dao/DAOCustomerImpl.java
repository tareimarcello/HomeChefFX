package logic.dao;

import logic.connection.AppDataStore;
import logic.dao.query.CustomerQuery;
import logic.dao.rowmapper.CustomerRowMapper;
import logic.exceptions.ConnectionException;
import logic.model.Customer;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.Objects;

public class DAOCustomerImpl extends JdbcDaoSupport{
    private final CustomerQuery query;

    public DAOCustomerImpl() throws ConnectionException {

        this.setDataSource(new AppDataStore().dataSource());
        query = new CustomerQuery();
    }


    public Customer get(long id) {
        assert getJdbcTemplate() != null;
        return getJdbcTemplate().query(query.selectCustomerQuery(id), new CustomerRowMapper()).getFirst();
    }


    public void save(Customer customer, String email, String password) {
        assert getJdbcTemplate() != null;
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(Objects.requireNonNull(getDataSource())).withProcedureName("insert_customer");
        MapSqlParameterSource in = new MapSqlParameterSource();
        in.addValue("var_name", customer.getName());
        in.addValue("var_surname", customer.getSurname());
        in.addValue("var_email", email);
        in.addValue("var_passwd", password);
        jdbcCall.execute(in);
    }


    public void update(Customer customer) {
        assert getJdbcTemplate() != null;
        getJdbcTemplate().update(query.updateCustomerQuery(customer.getID(),customer.getBookNot()));
    }


    public void setCustomerNot(long id, boolean bookNot){
        assert getJdbcTemplate() != null;
        getJdbcTemplate().update(query.updateCustomerQuery(id, bookNot));
    }


}
