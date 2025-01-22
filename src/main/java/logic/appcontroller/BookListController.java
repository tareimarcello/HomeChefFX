package logic.appcontroller;

import logic.beans.BookListBean;
import logic.beans.SessionParamBean;
import logic.dao.DAOBookImpl;
import logic.dao.DAOChefImpl;
import logic.dao.DAOCustomerImpl;
import logic.exceptions.ConnectionException;
import logic.model.Book;
import logic.patterns.ViewSetter;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookListController {

    public void loadBookList() throws ConnectionException {

        long idCurrentUser = ViewSetter.getSessionParam().getCurrentUserId();
        SessionParamBean.UserType type = ViewSetter.getSessionParam().getUserType();
        DAOCustomerImpl daoUser = new DAOCustomerImpl();
        DAOChefImpl daoChef = new DAOChefImpl();
        DAOBookImpl daoBook = new DAOBookImpl();
        List<Book> books = null;
        List<BookListBean> beanBooksList= new ArrayList<>();
        switch(type) {
            case SessionParamBean.UserType.CUSTOMER -> books = daoBook.getAllByCustomer(idCurrentUser);
            case SessionParamBean.UserType.CHEF -> books = daoBook.getAllByChefOpenApproved(idCurrentUser);
            default -> throw new IllegalArgumentException("User Not Valid");
        }
        //Start sonar service
        assert books != null;
        LocalDate now = LocalDate.now();
        Instant instant = Instant.from(now.atStartOfDay(ZoneId.systemDefault()));
        for (Book book : books){
            if(book.getData().after(Date.from(instant)) || book.getData().equals(Date.from(instant))) {
                BookListBean bean = new BookListBean();
                bean.setChefBean(daoChef.get(book.getChef()));
                bean.setBookState(book.getBookState());
                bean.setCitta(book.getCitta());
                bean.setCustomerBean(daoUser.get(book.getCustomer()));
                bean.setIdBook(book.getIdBook());
                bean.setData(book.getData());
                bean.setMeal(book.getMeal());
                bean.setVia(book.getVia());
                beanBooksList.add(bean);
            }
        }

        ViewSetter.setBookList(beanBooksList);
    }

    public void updateChefBook(BookListBean bean) throws ConnectionException {
        DAOBookImpl dao = new DAOBookImpl();
        Book acceptBook = new Book(bean.getIdBook(),bean.getCustomerBean().getID(),bean.getChefBean().getID(),bean.getBookState(),bean.getData(),bean.getMeal(),bean.getCitta());
        acceptBook.setVia(bean.getVia());
        dao.update(acceptBook);
    }
}
