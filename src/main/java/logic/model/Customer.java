package logic.model;

import logic.patterns.observer.ObserverNotification;

public class Customer extends User implements ObserverNotification {

    private boolean bookNot;

    public Customer (long id, String name, String surname, boolean bookNot) {

        super(id,name,surname);
        this.bookNot = bookNot;
    }

    public boolean getBookNot() {
        return bookNot;
    }

    public void setBookNot(boolean bookNot) {
        this.bookNot = bookNot;
    }

    @Override
    public void update() {
        setBookNot(true);
    }
}
