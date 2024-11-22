package logic.dao;

import logic.connection.AppDataStore;
import logic.dao.rowmapper.BookRowMapper;
import logic.exceptions.ConnectionException;
import logic.model.Book;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.Date;
import java.util.List;

public class DAOBookImpl extends JdbcDaoSupport implements DAOInterface<Book>{
    private static final String SELECT_OPEN_QUERY= "select * from book where chef=? && stato='OPEN'";
    private static final String SELECT_APPROVED_QUERY= "select * from book where chef=? && stato='APPROVED'";
    private static final String SELECT_ALL_QUERY= "select * from book";
    private static final String SELECT_APPROVED_OPEN_CHEF_QUERY= "select * from book where chef=? && (stato='APPROVED' OR stato='OPEN')";
    private static final String SELECT_OPEN_CUSTOMER_QUERY= "select from book where chef=? && customer = ? && stato='OPEN'";
    private static final String SELECT_REJECTED_CUSTOMER_QUERY= "select from book where chef=? && customer = ? && stato='REJECTED'";
    private static final String SELECT_QUERY_BY_ID= "select * from book WHERE idbook=?";
    private static final String INSERT_BOOK_QUERY= "insert into book (customer,chef,stato,data,pasto,citta,via) VALUES (?,?,?,?,?,?,?)";
    private static final String UPDATE_BOOK_QUERY= "UPDATE book SET customer = ?,chef = ?, stato=?,data=?,pasto=?,citta=?,via=?  WHERE idbook = ?";
    private static final String DELETE_BOOK_QUERY= "DELETE book WHERE idbook = ?";
    private static final String SELECT_ALL_BY_CUSTOMER= "SELECT * FROM book WHERE customer = ?";
    private static final String SELECT_ALL_BY_CHEF= "SELECT * FROM book WHERE chef = ?";
    private static final String SELECT_ALL_BY_CHEF_DATE= "SELECT * FROM book WHERE chef = ? && data = ? ";
    public DAOBookImpl() throws ConnectionException {
        this.setDataSource(new AppDataStore().dataSource());
    }

    @Override
    public Book get(long id) {

        assert getJdbcTemplate() != null;
        return getJdbcTemplate().query(SELECT_QUERY_BY_ID, new BookRowMapper(), id).getFirst();

    }

    @Override
    public List<Book> getAll() {

        assert getJdbcTemplate() != null;
        return  getJdbcTemplate().query(SELECT_ALL_QUERY, new BookRowMapper());
    }

    @Override
    public void save(Book book) {
        assert getJdbcTemplate() != null;
        getJdbcTemplate().update(INSERT_BOOK_QUERY, book.getCustomer(),book.getChef(),book.getBookState().toString(),book.getData(),book.getMeal().toString(),book.getCitta(),book.getVia());
    }

    @Override
    public void update(Book book) {
        assert getJdbcTemplate() != null;
        getJdbcTemplate().update(UPDATE_BOOK_QUERY, book.getCustomer(),book.getChef(),book.getBookState().toString(),book.getData(),book.getMeal().toString(),book.getCitta(),book.getVia(), book.getIdBook());
    }
    @Override
    public void delete(Book book) {
        assert getJdbcTemplate() != null;
        getJdbcTemplate().update(DELETE_BOOK_QUERY, book.getIdBook());
    }

    public List<Book> getAllByCustomer(long idCust) {
        assert getJdbcTemplate() != null;
        return  getJdbcTemplate().query(SELECT_ALL_BY_CUSTOMER, new BookRowMapper(),idCust);
    }

    public List<Book> getAllByChefOpenApproved(long idChef) {
        assert getJdbcTemplate() != null;
        return  getJdbcTemplate().query(SELECT_APPROVED_OPEN_CHEF_QUERY, new BookRowMapper(),idChef);
    }

    public Book getBookByChefDate(long idChef, Date dateBook){
        assert getJdbcTemplate() != null;
        return getJdbcTemplate().query(SELECT_ALL_BY_CHEF_DATE, new BookRowMapper(),idChef,dateBook).getFirst();
    }

}
