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

    public boolean setRes(String res) {
        if(res.isEmpty()){
            return false;
        }
        this.res = res;
        return true;
    }

    public String getCity() {
        return city;
    }

    public boolean setCity(String city) {
        if(city.isEmpty()){
            return false;
        }
        while(city.endsWith(" ")){
            city =city.substring(0,city.length()-1);
        }
        this.city = city;
        return true;
    }
}
