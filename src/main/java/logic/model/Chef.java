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

    @Override
    public String getInfo(int type) {
        switch(type){
            case (0) -> {
                return restaurant;
            }
            case (1)->{
                return bestDish;
            }
            case (2)->{
                return citta;
            }
            default-> throw new IllegalArgumentException();
        }
    }

    @Override
    public void setInfo(Object info, int type) {
        switch(type){
            case (0) -> {
                 restaurant= (String)info;
            }
            case (1)->{
                 bestDish=(String)info;
            }
            case (2)->{
                citta=(String)info;
            }
            default->{
                throw new IllegalArgumentException();
            }
        }
    }
}
