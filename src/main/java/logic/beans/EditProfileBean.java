package logic.beans;

public class EditProfileBean {

    private String pswd;
    private long userId;
    private String email;


    public EditProfileBean(String mail, String pswd, long userId) {
        this.email = mail;
        this.userId=userId;
        this.pswd=pswd;
    }


    public String getPswd() {
        return pswd;
    }

    public void setPswd(String pswd) {
        this.pswd = pswd;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
