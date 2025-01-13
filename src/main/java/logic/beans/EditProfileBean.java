package logic.beans;

import logic.homechefutil.HomeChefUtil;

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

    public boolean setPswd(String pswd) {
        if(pswd.isEmpty()){
            return false;
        }
        this.pswd = pswd;
        return true;
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

    public boolean setEmail(String email) {
        if(email.isEmpty() || HomeChefUtil.isValidEmail(email)){
            return false;
        }
        this.email = email;
        return true;
    }
}
