package logic.model;

import java.io.Serializable;

public class Chat implements Serializable {

    private long id;
    private long customer;
    private long chef;

    public Chat (long id, long customer, long chef){

        this.id = id;
        this.customer = customer;
        this.chef = chef;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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


}
