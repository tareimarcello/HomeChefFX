package logic.beans;

import logic.model.Book;

import java.util.Date;

public class BookListBean {

    private long idBook;
    private long idCust;
    private String nameChef;
    private String surnameChef;
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

    public long getIdCust() {
        return idCust;
    }

    public void setIdCust(long idCust) {
        this.idCust = idCust;
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

    public String getNameChef() {
        return nameChef;
    }

    public void setNameChef(String nameChef) {
        this.nameChef = nameChef;
    }

    public String getSurnameChef() {
        return surnameChef;
    }

    public void setSurnameChef(String surnameChef) {
        this.surnameChef = surnameChef;
    }
}
