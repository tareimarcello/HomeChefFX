package logic.dao.rowmapper;

import logic.model.Book;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookRowMapper implements RowMapper<Book> {
    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        Book retBook = new Book(
                rs.getInt("idbook"),
                rs.getInt("customer"),
                rs.getInt("chef"),
                rs.getString("stato"),
                rs.getDate("data"),
                rs.getString("pasto"),
                rs.getString("citta")
        );
        retBook.setVia(rs.getString("via"));
        return retBook;
    }
}
