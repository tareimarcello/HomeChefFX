package logic.beans;

import logic.model.Book;
import logic.model.User;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class BookBean {

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

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public User getChef() {
        return chef;
    }

    public void setChef(User chef) {
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

    public boolean setDataIn(LocalDate data) {
        LocalDate now = LocalDate.now();
        if (data == null || data.isBefore(now) || data.isEqual(now)) {
            return false;
        }
        Instant instant = Instant.from(data.atStartOfDay(ZoneId.systemDefault()));
        this.data = Date.from(instant);
        return true;
    }

    public boolean setCityIn(String city) {
        if(city.isEmpty()){
            return false;
        }
        this.citta = city;
        return true;
    }


    public boolean setViaIn(String via){
        if(via.isEmpty()){
            return false;
        }
        this.via = via;
        return true;
    }
}
