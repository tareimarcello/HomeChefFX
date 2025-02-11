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

public class DAOBookImpl extends JdbcDaoSupport implements DAOInterface<Book>{
    private final BookQuery query;

    public DAOBookImpl() throws ConnectionException {
        this.setDataSource(new AppDataStore().dataSource());
        query = new BookQuery();
    }

    @Override
    public Book get(long id) {

        assert getJdbcTemplate() != null;
        return getJdbcTemplate().query(query.selectQueryBYId(id), new BookRowMapper()).getFirst();

    }

    @Override
    public List<Book> getAll() {

        assert getJdbcTemplate() != null;
        return  getJdbcTemplate().query(query.selectAllQuery(), new BookRowMapper());
    }

    @Override
    public void save(Book book) {
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        String date = df.format(book.getData());
        assert getJdbcTemplate() != null;
        getJdbcTemplate().update(query.insertQuery(book.getCustomer(),book.getChef(),
                book.getBookState().toString(), book.getMeal().toString(),book.getCitta(),book.getVia(),date));
    }

    @Override
    public void update(Book book) {
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        String date = df.format(book.getData());
        assert getJdbcTemplate() != null;
        getJdbcTemplate().update(query.updateQuery( book.getCustomer(),book.getChef(),book.getBookState().toString(),book.getMeal().toString(),book.getCitta(),book.getVia(),date, book.getIdBook()));
    }
    @Override
    public void delete(Book book) {
        assert getJdbcTemplate() != null;
        getJdbcTemplate().update(query.deleteQuery(book.getIdBook()));
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
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        String date = df.format(dateBook);
        assert getJdbcTemplate() != null;
        return getJdbcTemplate().query(query.getAllByChefDate(idChef, date), new BookRowMapper()).getFirst();
    }

}
