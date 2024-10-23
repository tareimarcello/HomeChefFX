package logic.beans;

public class ResultSearchBean {

    private long idChef;
    private String nameChef;
    private String restaurant;
    private String bestDish;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    private String city;

    public long getIdChef() {
        return idChef;
    }

    public void setIdChef(long idChef) {
        this.idChef = idChef;
    }

    public String getNameChef() {
        return nameChef;
    }

    public void setNameChef(String nameChef) {
        this.nameChef = nameChef;
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
