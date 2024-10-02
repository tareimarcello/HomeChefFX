package logic.patterns;

import logic.beans.HomeChefBean;

public class ViewSetter {

    private static ViewSetter setter;

    private HomeChefBean hcbean;

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


}
