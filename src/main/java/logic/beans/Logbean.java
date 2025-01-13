package logic.beans;

public class Logbean {

    private String email;
    private String password;


    public String getEmail() {
        return email;
    }

    public boolean setEmail(String email) {
        if (email == null || email.equals("")) {
            return false;
        }
        this.email = email;
        return true;
    }

    public String getPassword() {
        return password;
    }

    public boolean setPassword(String password) {
        if (password == null || password.equals("")) {
            return false;
        }
        this.password = password;
        return true;
    }
}
