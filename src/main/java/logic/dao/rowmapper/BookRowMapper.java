package logic.dao.rowmapper;

import logic.dao.DAOChefImpl;
import logic.dao.DAOCustomerImpl;
import logic.exceptions.ConnectionException;
import logic.exceptions.Exceptions;
import logic.model.Book;
import logic.model.Chef;
import logic.model.Customer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookRowMapper implements RowMapper<Book> {
    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        DAOChefImpl daoChef = null;
        DAOCustomerImpl daoCustomer = null;
        try {
            daoChef = new DAOChefImpl();
            daoCustomer = new DAOCustomerImpl();
        } catch (ConnectionException e) {
            throw new RuntimeException(e);
        }
        Chef chef = daoChef.get(rs.getInt("chef"));
        Customer cust = daoCustomer.get(rs.getInt("customer"));
        Book retBook = new Book(
                rs.getInt("idbook"),
                cust,
                chef,
                Book.BookStatus.valueOf(rs.getString("stato")),
                rs.getDate("data"),
                Book.BookMeal.valueOf(rs.getString("pasto")),
                rs.getString("citta")
        );
        retBook.setVia(rs.getString("via"));
        return retBook;
    }
}
