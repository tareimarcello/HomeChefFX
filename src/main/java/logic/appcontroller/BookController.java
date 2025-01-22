package logic.appcontroller;

import logic.beans.BookBean;
import logic.dao.DAOBookImpl;
import logic.exceptions.ChefNotAvailableException;
import logic.exceptions.ConnectionException;
import logic.model.Book;
import logic.patterns.Setter;

import java.util.NoSuchElementException;

public class BookController {


    public void saveBook(BookBean bean) throws ConnectionException {
        DAOBookImpl dao = new DAOBookImpl();
        long idChef = Setter.getHcvisitbean().getId();
        try {
            if (dao.getBookByChefDate(idChef, bean.getData()) != null) {
                throw new ChefNotAvailableException("Chef not available for this date");
            }
        } catch (NoSuchElementException e) {
            long cust = Setter.getSessionParam().getCurrentUserId();
            Book book = new Book(-1, cust, idChef, Book.BookStatus.OPEN, bean.getData(), bean.getMeal(), bean.getCitta());
            book.setVia(bean.getVia());
            dao.save(book);
        }
    }
}
