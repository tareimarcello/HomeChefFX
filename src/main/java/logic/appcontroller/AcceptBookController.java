package logic.appcontroller;

import logic.beans.BookListBean;
import logic.dao.DAOBookImpl;
import logic.dao.DAOCustomerImpl;
import logic.exceptions.ConnectionException;
import logic.model.Book;
import logic.model.Customer;

public class AcceptBookController {

    private Customer cust;
    private Book book;

   public AcceptBookController(BookListBean bean) throws ConnectionException {
        this.cust=bean.getCustomerBean();
        loadCurrBook(bean.getIdBook());
    }

    public void updateChefBook(BookListBean bean) throws ConnectionException {
        DAOBookImpl dao = new DAOBookImpl();
        DAOCustomerImpl daoCust = new DAOCustomerImpl();
        book.setBookState(bean.getBookState());
        dao.update(book);
        daoCust.update(cust);
    }

    private void loadCurrBook(long idBook) throws ConnectionException {
       DAOBookImpl dao = new DAOBookImpl();
       this.book = dao.get(idBook);
       book.attach(cust);
    }

    public Customer getCust() {
        return cust;
    }

    public void setCust(Customer cust) {
        this.cust = cust;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
