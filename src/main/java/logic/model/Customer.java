package logic.model;

public class Customer extends User{

    private boolean bookNot;

    public Customer (long id, String name, String surname, String email, String password, boolean bookNot) {

        super(id,name,surname,email,password);
        this.bookNot = bookNot;
    }

    public boolean getBookNot() {
        return bookNot;
    }

    public void setBookNot(boolean bookNot) {
        this.bookNot = bookNot;
    }
}
