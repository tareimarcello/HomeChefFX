package logic.beans;

public class EditChefProfileBean extends EditProfileBean{
    private String res;
    private String city;
    public EditChefProfileBean(String mail, String pswd, long userId,String restaurant, String city) {
        super(mail, pswd, userId);
        this.res=restaurant;
        this.city = city;
    }

    public String getRes() {
        return res;
    }

    public void setRes(String res) {
        this.res = res;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
