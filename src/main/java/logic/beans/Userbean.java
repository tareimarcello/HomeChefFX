package logic.beans;

import logic.homechefutil.HomeChefUtil;

public class Userbean {

    private String name;
    private String surname;
    private String email;
    private String password;



    protected Userbean (String name, String surname, String email, String password){

        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }


    public String getNameBean() {
        return name;
    }

    public void setNameBean(String name) {
        this.name = name;
    }

    public String getSurnameBean() {
        return surname;
    }

    public void setSurnameBean(String surname) {
        this.surname = surname;
    }

    public String getEmailBean() {
        return email;
    }

    public void setEmailBean(String email) {
        this.email = email;
    }

    public String getPasswordBean() {
        return password;
    }

    public void setPasswordBean(String password) {
        this.password = password;
    }

    public boolean checkValid(String name, String surname, String email, String password) {
        return !name.isEmpty() && !surname.isEmpty() && HomeChefUtil.isValidEmail(email) && !password.isEmpty();
    }
}
