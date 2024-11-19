package logic.appcontroller;

import logic.beans.BookBean;
import logic.beans.SessionParamBean;
import logic.dao.DAOBookImpl;
import logic.dao.DAOUserImpl;
import logic.exceptions.ConnectionException;
import logic.model.Book;
import logic.patterns.ViewSetter;

import java.util.ArrayList;
import java.util.List;

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
            default -> {
                // inserire eccezione tipo non riconosciuto
            }
        }

        assert books != null;
        for (Book book : books){

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

        ViewSetter.setBookList(beanBooksList);
    }

    public void saveBook(BookBean bean) throws ConnectionException{

        DAOBookImpl daoBook = new DAOBookImpl();
        long idChef=ViewSetter.getHcvisitbean().getId();
        long idCust=ViewSetter.getSessionParam().getCurrentUserId();
        Book book = new Book(-1,idCust,idChef, Book.BookStatus.OPEN,bean.getData(),bean.getMeal(), bean.getCitta());
        book.setVia(bean.getVia());
        daoBook.save(book);
    }

}