package logic.dao;

import logic.connection.AppDataStore;
import logic.dao.query.BookQuery;
import logic.dao.rowmapper.BookRowMapper;
import logic.exceptions.ConnectionException;
import logic.model.Book;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class DAOBookImpl extends JdbcDaoSupport{
    private final BookQuery query;
    private static final String PATTERN = "yyyy/MM/dd";

    public DAOBookImpl() throws ConnectionException {
        this.setDataSource(new AppDataStore().dataSource());
        query = new BookQuery();
    }

    public Book get(long id) {

        assert getJdbcTemplate() != null;
        return getJdbcTemplate().query(query.selectQueryBYId(id), new BookRowMapper()).getFirst();

    }

    public void save(long cust, long chef,Book.BookStatus status,Date data,Book.BookMeal meal,String city, String via) {
        DateFormat df = new SimpleDateFormat(PATTERN);
        String date = df.format(data);
        assert getJdbcTemplate() != null;
        getJdbcTemplate().update(query.insertQuery(cust,chef,
                status.toString(), meal.toString(),city,via,date));
    }

    public void update(Book book) {
        DateFormat df = new SimpleDateFormat(PATTERN);
        String date = df.format(book.getData());
        assert getJdbcTemplate() != null;
        getJdbcTemplate().update(query.updateQuery(book,date, book.getIdBook()));
    }


    public List<Book> getAllByCustomer(long idCust) {
        assert getJdbcTemplate() != null;
        return  getJdbcTemplate().query(query.selectAllByCustQuery(idCust), new BookRowMapper());
    }

    public List<Book> getAllByChefOpenApproved(long idChef) {
        assert getJdbcTemplate() != null;
        return  getJdbcTemplate().query(query.selectAllByOPenApproved(idChef), new BookRowMapper());
    }

    public Book getBookByChefDate(long idChef, Date dateBook){
        DateFormat df = new SimpleDateFormat(PATTERN);
        String date = df.format(dateBook);
        assert getJdbcTemplate() != null;
        return getJdbcTemplate().query(query.getAllByChefDate(idChef, date), new BookRowMapper()).getFirst();
    }

}
