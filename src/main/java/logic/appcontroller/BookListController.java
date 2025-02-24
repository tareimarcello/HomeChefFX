package logic.appcontroller;

import logic.beans.BookListBean;
import logic.beans.SessionParamBean;
import logic.dao.DAOBookImpl;
import logic.dao.DAOChefImpl;
import logic.exceptions.ConnectionException;
import logic.model.Book;
import logic.model.User;
import logic.patterns.Setter;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookListController {

    public List<BookListBean> loadBookList() throws ConnectionException {

        long idCurrentUser = Setter.getSessionParam().getCurrentUserId();
        SessionParamBean.UserType type = Setter.getSessionParam().getUserType();
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
                User ch = daoChef.get(book.getChef());
                bean.setNameChef(ch.getName());
                bean.setSurnameChef(ch.getSurname());
                bean.setBookState(book.getBookState());
                bean.setCitta(book.getCitta());
                bean.setIdCust(book.getCustomer());
                bean.setIdBook(book.getIdBook());
                bean.setData(book.getData());
                bean.setMeal(book.getMeal());
                bean.setVia(book.getVia());
                beanBooksList.add(bean);
            }
        }

        return beanBooksList;
    }

}
