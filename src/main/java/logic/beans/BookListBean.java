package logic.beans;

import logic.model.Book;
import logic.model.User;

import java.util.Date;

public class BookListBean {

    private long idBook;
    private User customer;
    private User chef;
    private Date data;
    private Book.BookStatus bookState;
    private Book.BookMeal meal;
    private String citta;
    private String via;

    public long getIdBook() {
        return idBook;
    }

    public void setIdBook(long idBook) {
        this.idBook = idBook;
    }

    public User getCustomerBean() {
        return customer;
    }

    public void setCustomerBean(User customer) {
        this.customer = customer;
    }

    public User getChefBean() {
        return chef;
    }

    public void setChefBean(User chef) {
        this.chef = chef;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Book.BookStatus getBookState() {
        return bookState;
    }

    public void setBookState(Book.BookStatus bookState) {
        this.bookState = bookState;
    }

    public Book.BookMeal getMeal() {
        return meal;
    }

    public void setMeal(Book.BookMeal meal) {
        this.meal = meal;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }
}
