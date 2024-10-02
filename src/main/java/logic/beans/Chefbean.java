package logic.beans;

public class Chefbean extends Userbean{

    private String citta;
    private String restaurant;
    private String bestDish;



    public Chefbean (String name, String surname, String email, String psw, String citta, String restaurant, String bestDish){

        super (name, surname, email, psw);

        this.citta=citta;
        this.restaurant = restaurant;
        this.bestDish = bestDish;

    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public String getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(String restaurant) {
        this.restaurant = restaurant;
    }

    public String getBestDish() {
        return bestDish;
    }

    public void setBestDish(String bestDish) {
        this.bestDish = bestDish;
    }
}
