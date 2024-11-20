package logic.appcontroller;

import logic.beans.BookBean;
import logic.beans.SessionParamBean;
import logic.dao.DAOBookImpl;
import logic.dao.DAOUserImpl;
import logic.exceptions.ChefNotAvailableException;
import logic.exceptions.ConnectionException;
import logic.model.Book;
import logic.patterns.ViewSetter;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

public class BookController {

    public void loadBookList() throws ConnectionException {

        long idCurrentUser = ViewSetter.getSessionParam().getCurrentUserId();
        SessionParamBean.UserType type = ViewSetter.getSessionParam().getUserType();
        DAOUserImpl daoUser = new DAOUserImpl();
        DAOBookImpl daoBook = new DAOBookImpl();
        List<Book> books = null;
        List<BookBean> beanBooksList= new ArrayList<>();
        switch(type) {
            case SessionParamBean.UserType.CUSTOMER -> books = daoBook.getAllByCustomer(idCurrentUser);
            case SessionParamBean.UserType.CHEF -> books = daoBook.getAllByChef(idCurrentUser);
            default -> throw new IllegalArgumentException("User Not Valid");
        }

        assert books != null;
        LocalDate now = LocalDate.now();
        Instant instant = Instant.from(now.atStartOfDay(ZoneId.systemDefault()));
        for (Book book : books){
            if(book.getData().after(Date.from(instant)) || book.getData().equals(Date.from(instant))) {
                BookBean bean = new BookBean();
                bean.setChef(daoUser.get(book.getChef()));
                bean.setBookState(book.getBookState());
                bean.setCitta(book.getCitta());
                bean.setCustomer(daoUser.get(book.getCustomer()));
                bean.setIdBook(book.getIdBook());
                bean.setData(book.getData());
                bean.setMeal(book.getMeal());
                bean.setVia(book.getVia());
                beanBooksList.add(bean);
            }
        }

        ViewSetter.setBookList(beanBooksList);
    }

    public void saveBook(BookBean bean) throws ConnectionException{
        DAOBookImpl dao = new DAOBookImpl();
        long idChef=ViewSetter.getHcvisitbean().getId();
        try {
            if (dao.getBookByChefDate(idChef, bean.getData()) != null) {
                throw new ChefNotAvailableException("Chef not available for this date");
            }
        }catch(NoSuchElementException e) {
            long idCust = ViewSetter.getSessionParam().getCurrentUserId();
            Book book = new Book(-1, idCust, idChef, Book.BookStatus.OPEN, bean.getData(), bean.getMeal(), bean.getCitta());
            book.setVia(bean.getVia());
            dao.save(book);
        }
    }


}
