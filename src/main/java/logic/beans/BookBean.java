package logic.beans;

import logic.model.Book;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class BookBean {

    private Date data;
    private Book.BookMeal meal;
    private String citta;
    private String via;


    public Date getData() {
        return data;
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


    public String getVia() {
        return via;
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
