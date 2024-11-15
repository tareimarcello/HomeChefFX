package logic.beans;

public class EditChefProfileBean extends EditProfileBean{
    private String res;
    public EditChefProfileBean(String mail, String pswd, long userId,String restaurant) {
        super(mail, pswd, userId);
        this.res=restaurant;
    }

    public String getRes() {
        return res;
    }

    public void setRes(String res) {
        this.res = res;
    }
}
