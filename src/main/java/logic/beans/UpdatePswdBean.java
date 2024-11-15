package logic.beans;

public class UpdatePswdBean {

    private String pswd;
    private long userId;


    public UpdatePswdBean(String pswd, long userId) {
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
}
