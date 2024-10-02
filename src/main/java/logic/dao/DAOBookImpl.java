package logic.dao;

import logic.model.Book;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

public class DAOBookImpl extends JdbcDaoSupport implements DAOInterface<Book>{
    private static final String SELECT_OPEN_QUERY= "select * from book where chef=? && stato='OPEN'";
    private static final String SELECT_APPROVED_QUERY= "select * from book where chef=? && stato='APPROVED'";
    private static final String SELECT_ALL_QUERY= "select * from book";
    private static final String SELECT_APPROVED_CUSTOMER_QUERY= "select from book where chef=? && customer = ? && stato='APPROVED'";
    private static final String SELECT_OPEN_CUSTOMER_QUERY= "select from book where chef=? && customer = ? && stato='OPEN'";
    private static final String SELECT_REJECTED_CUSTOMER_QUERY= "select from book where chef=? && customer = ? && stato='REJECTED'";

    @Override
    public Book get(long id) {
        return null;
    }

    @Override
    public List<Book> getAll() {
        return List.of();
    }

    @Override
    public void save(Book book) {

    }

    @Override
    public void update(Book book) {

    }

    @Override
    public void delete(Book book) {

    }
}
