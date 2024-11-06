package logic.dao;

import logic.connection.AppDataStore;
import logic.dao.rowmapper.CustomerRowMapper;
import logic.dao.rowmapper.RowLastInsertIdMapper;
import logic.model.Customer;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;
import java.util.Objects;

public class DAOCustomerImpl extends JdbcDaoSupport implements DAOInterface<Customer>{

    private static final String SELECT_ALL_CUSTOMER = "SELECT * FROM customer";
    private static final String SELECT_QUERY = "SELECT * FROM customer JOIN user ON (customer.idUser=user.iduser) WHERE customer.idUser=?";
    private static final String UPDATE_QUERY = "UPDATE customer SET idUser = ? WHERE idUser=?";
    private static final String DELETE_QUERY = "DELETE FROM customer WHERE idUser=?";
    private static final String SELECT_LAST_INSERT_ID = "SELECT LAST_INSERT_ID()";



    public DAOCustomerImpl() throws Exception {

        this.setDataSource(new AppDataStore().dataSource());
    }

    @Override
    public Customer get(long id) {
        assert getJdbcTemplate() != null;
        return getJdbcTemplate().query(SELECT_QUERY, new CustomerRowMapper(), id).getFirst();
    }

    @Override
    public List<Customer> getAll() {

        return  getJdbcTemplate().query(SELECT_ALL_CUSTOMER, new CustomerRowMapper());

    }

    @Override
    public void save(Customer customer) {
        assert getJdbcTemplate() != null;
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(Objects.requireNonNull(getDataSource())).withProcedureName("insert_customer");
        MapSqlParameterSource in = new MapSqlParameterSource();
        in.addValue("var_name", customer.getName());
        in.addValue("var_surname", customer.getSurname());
        in.addValue("var_email", customer.getEmail());
        in.addValue("var_passwd", customer.getPassword());
        jdbcCall.execute(in);
    }

    @Override
    public void update(Customer customer) {
        assert getJdbcTemplate() != null;
        getJdbcTemplate().update(UPDATE_QUERY,  customer.getID());
    }

    @Override
    public void delete(Customer customer) {
        assert getJdbcTemplate() != null;
        getJdbcTemplate().update(DELETE_QUERY, customer.getID());
    }


    private Long getLastID (){

        assert getJdbcTemplate() != null;
        return getJdbcTemplate().query(SELECT_LAST_INSERT_ID, new RowLastInsertIdMapper()).getFirst();
    }
}
