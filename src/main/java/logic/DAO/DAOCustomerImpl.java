package logic.DAO;

import logic.model.Customer;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

public class DAOCustomerImpl extends JdbcDaoSupport implements DAOInterface<Customer>{

    private static final String SELECT_ALL_CUSTOMER = "SELECT * FROM customer";
    private static final String SELECT_QUERY = "SELECT * FROM customer WHERE idUser=?";
    private static final String INSERT_QUERY = "INSERT INTO customer (idUser) VALUES (?)";
    private static final String UPDATE_QUERY = "UPDATE customer SET idUser = ? WHERE idUser=?";
    private static final String DELETE_QUERY = "DELETE FROM customer WHERE idUser=?";
    @Override
    public Customer get(long id) {
        assert getJdbcTemplate() != null;
        return (Customer) getJdbcTemplate().query(SELECT_QUERY, new CustomerRowMapper(), id).getFirst();
    }

    @Override
    public List<Customer> getAll() {
        return List.of();
    }

    @Override
    public void save(Customer customer) {
        assert getJdbcTemplate() != null;
        getJdbcTemplate().update(INSERT_QUERY, customer.getID());
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
}
