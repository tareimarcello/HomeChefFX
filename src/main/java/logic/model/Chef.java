package logic.model;


public class Chef extends User {

    private String restaurant;
    private String bestDish;
    private String citta;

    public Chef (long id, String name, String surname,String restaurant, String bestDish, String city){

        super(id,name,surname);
        this.restaurant = restaurant;
        this.bestDish = bestDish;
        this.citta = city;

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

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }
}
