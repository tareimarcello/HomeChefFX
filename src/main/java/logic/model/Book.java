package logic.model;


import java.util.Date;

public class Book {
    private long idBook;
    private long customer;
    private long chef;
    private Date data;
    private String bookState;
    private String meal;
    private String citta;
    private String via;

    public Book(int idbook, int customer, int chef, String stato, Date data, String pasto, String citta) {
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

    public long getCustomer() {
        return customer;
    }

    public void setCustomer(long customer) {
        this.customer = customer;
    }

    public long getChef() {
        return chef;
    }

    public void setChef(long chef) {
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
    public void setBookState(String bookState) {
        this.bookState = bookState;     //passare l'enum con il tostring
    }
    public String getBookState(){
        return this.bookState;
    }
    public void setMeal(String meal) {
        this.meal=meal;
    }
    public String getMeal(){
        return this.meal;
    }
}
