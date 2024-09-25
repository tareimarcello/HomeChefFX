package logic.DAO;

import model.Customer;

import java.util.List;

public class DAOCustomerImpl implements DAOInterface<Customer>{

    private static final String SELECT_ALL_CUSTOMER = "SELECT * FROM customer";
    private static final String SELECT_QUERY = "SELECT * FROM customer WHERE idUser=?";
    private static final String INSERT_QUERY = "INSERT INTO customer (idUser) VALUES (?)";
    private static final String UPDATE_QUERY = "UPDATE customer SET idUser = ? WHERE idUser=?";
    private static final String DELETE_QUERY = "DELETE FROM customer WHERE idUser=?";
    @Override
    public Customer get(long id) {
        return null;
    }

    @Override
    public List<Customer> getAll() {
        return List.of();
    }

    @Override
    public void save(Customer customer) {

    }

    @Override
    public void update(Customer customer) {

    }

    @Override
    public void delete(Customer customer) {

    }
}
