package logic.model;


public abstract class User {

    private long id;
    private String name;
    private String surname;


    public User (long id, String name, String surname){

        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public long getID() {
        return id;
    }

    public void setID(long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public abstract Object getInfo(int type);
    public abstract void setInfo(Object info, int type);
}
