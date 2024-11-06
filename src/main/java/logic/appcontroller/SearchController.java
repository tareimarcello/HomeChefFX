package logic.appcontroller;

import logic.beans.ResultSearchBean;
import logic.beans.SearchBean;
import logic.dao.DAOChefImpl;
import logic.model.Chef;
import logic.patterns.ViewSetter;
import java.util.ArrayList;
import java.util.List;

public class SearchController {


    public void searchChefList(SearchBean chefBean) throws Exception {

        DAOChefImpl daoChef = new DAOChefImpl();
        List<Chef> chefListResult = daoChef.getChefByParam(chefBean);
        List<ResultSearchBean> chefBeanResult = new ArrayList<>();
        for (Chef chef : chefListResult) {

            ResultSearchBean bean = new ResultSearchBean();
            bean.setNameChef(chef.getName()+" "+chef.getSurname());
            bean.setBestDish(chef.getBestDish());
            bean.setRestaurant(chef.getRestaurant());
            bean.setCity(chef.getCitta());
            bean.setIdChef(chef.getID());
            chefBeanResult.add(bean);
        }

        ViewSetter.getInstance().setChefList(chefBeanResult);

    }

}


//Non funziona la search del nome se scrivo nome e cognome da rivedere bene la DAO coinvolta