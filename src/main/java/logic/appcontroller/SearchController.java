package logic.appcontroller;

import logic.beans.ResultSearchBean;
import logic.beans.SearchBean;
import logic.dao.DAOChefImpl;
import logic.model.Chef;
import logic.patterns.ViewSetter;

import javax.naming.directory.SearchResult;
import java.util.ArrayList;
import java.util.List;

public class SearchController {


    public void searchChefList(SearchBean chefBean){

        DAOChefImpl daoChef = new DAOChefImpl();
        List<Chef> chefListResult = daoChef.getChefByParam(chefBean);
        List<ResultSearchBean> chefBeanResult = new ArrayList<>();
        for (Chef chef : chefListResult) {

            ResultSearchBean bean = new ResultSearchBean();
            bean.setNameChef(chef.getName());
            bean.setBestDish(chef.getBestDish());
            bean.setRestaurant(chef.getRestaurant());
            bean.setIdChef(chef.getID());
            chefBeanResult.add(bean);
        }

        ViewSetter.getInstance().setChefList(chefBeanResult);

    }

}
