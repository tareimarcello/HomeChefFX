package logic.appcontroller;

import logic.beans.BookBean;
import logic.dao.DAOBookImpl;
import logic.dao.DAOChefImpl;
import logic.dao.DAOCustomerImpl;
import logic.exceptions.ChefNotAvailableException;
import logic.exceptions.ConnectionException;
import logic.model.Book;
import logic.model.Chef;
import logic.model.Customer;
import logic.patterns.ViewSetter;

import java.util.NoSuchElementException;

public class BookController {


    public void saveBook(BookBean bean) throws ConnectionException {
        DAOBookImpl dao = new DAOBookImpl();
        long idChef = ViewSetter.getHcvisitbean().getId();
        try {
            if (dao.getBookByChefDate(idChef, bean.getData()) != null) {
                throw new ChefNotAvailableException("Chef not available for this date");
            }
        } catch (NoSuchElementException e) {
            DAOCustomerImpl daoCust = new DAOCustomerImpl();
            DAOChefImpl daoChef = new DAOChefImpl();
            Customer cust = daoCust.get(ViewSetter.getSessionParam().getCurrentUserId());
            Chef chef = daoChef.get(idChef);
            Book book = new Book(-1, cust, chef, Book.BookStatus.OPEN, bean.getData(), bean.getMeal(), bean.getCitta());
            book.setVia(bean.getVia());
            dao.save(book);
        }
    }
}
