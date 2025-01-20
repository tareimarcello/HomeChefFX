package logic.model;

import java.util.Date;

public class Book {
    private long idBook;
    private Customer customer;
    private Chef chef;
    private Date data;
    private BookStatus bookState;
    private BookMeal meal;
    private String citta;
    private String via;

    public enum BookStatus{
        OPEN,REJECTED,APPROVED
    }
    public enum BookMeal{
        LUNCH,DINNER
    }
    public Book(long idbook, Customer customer, Chef chef, BookStatus stato, Date data, BookMeal pasto, String citta) {
        this.idBook = idbook;
        this.customer = customer;
        this.chef = chef;
        this.data = data;
        this.bookState = stato;
        this.meal = pasto;
        this.citta = citta;

    }

    public long getIdBook() {
        return idBook;
    }

    public void setIdBook(long idBook) {
        this.idBook = idBook;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Chef getChef() {
        return chef;
    }

    public void setChef(Chef chef) {
        this.chef = chef;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
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
    public void setBookState(BookStatus bookState) {
        this.bookState = bookState;     //passare l'enum con il tostring
    }
    public BookStatus getBookState(){
        return this.bookState;
    }
    public void setMeal(BookMeal meal) {
        this.meal=meal;
    }
    public BookMeal getMeal(){
        return this.meal;
    }
}
