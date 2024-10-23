package logic.patterns;

import logic.beans.HomeChefBean;
import logic.beans.ResultSearchBean;

import java.util.ArrayList;
import java.util.List;

public class ViewSetter {

    private static ViewSetter setter;

    private HomeChefBean hcbean;
    private HomeChefBean hcvisitbean;
    private List<ResultSearchBean> chefList;


    private ViewSetter (){


    }

    public static ViewSetter getInstance(){

        if (setter==null)
           setter = new ViewSetter();

        return setter;
    }

    public HomeChefBean getHcbean() {
        return hcbean;
    }

    public void setHcbean(HomeChefBean hcbean) {
        this.hcbean = hcbean;
    }

    public List<ResultSearchBean> getChefList() {
        return chefList;
    }

    public void setChefList(List<ResultSearchBean> chefList) {
        this.chefList = chefList;
    }

    public HomeChefBean getHcvisitbean() {
        return hcvisitbean;
    }

    public void setHcvisitbean(HomeChefBean hcvisitbean) {
        this.hcvisitbean = hcvisitbean;
    }
}
