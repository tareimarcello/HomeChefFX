package logic.appcontroller;

import logic.beans.BookListBean;
import logic.dao.DAOBookImpl;
import logic.exceptions.ConnectionException;
import logic.model.Book;
import logic.model.Customer;

public class AcceptBookController {
    private Customer cust;

   public AcceptBookController(BookListBean bean) {
        this.cust=bean.getCustomerBean();
    }

    public void updateChefBook(BookListBean bean) throws ConnectionException {
        DAOBookImpl dao = new DAOBookImpl();
        Book acceptBook = new Book(bean.getIdBook(),bean.getCustomerBean().getID(),bean.getChefBean().getID(),bean.getBookState(),bean.getData(),bean.getMeal(),bean.getCitta());
        acceptBook.setVia(bean.getVia());
        dao.update(acceptBook);
    }

    public Customer getCust() {
        return cust;
    }

    public void setCust(Customer cust) {
        this.cust = cust;
    }
}
