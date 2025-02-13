package logic.appcontroller;

import logic.beans.ResultSearchBean;
import logic.beans.SearchBean;
import logic.dao.DAOChefImpl;
import logic.exceptions.ConnectionException;
import logic.exceptions.NoResultFoundException;
import logic.model.Chef;
import logic.patterns.Setter;
import java.util.ArrayList;
import java.util.List;

public class SearchController {


    public void searchChefList(SearchBean chefBean) throws ConnectionException, NoResultFoundException {

        DAOChefImpl daoChef = new DAOChefImpl();
        List<Chef> chefListResult = daoChef.getChefByParam(chefBean);
        List<ResultSearchBean> chefBeanResult = new ArrayList<>();
        if(chefListResult.isEmpty()) {
            throw new NoResultFoundException("No results found");
        }else {
            for (Chef chef : chefListResult) {

                ResultSearchBean bean = new ResultSearchBean();
                bean.setNameChef(chef.getName() + " " + chef.getSurname());
                bean.setBestDish(chef.getBestDish());
                bean.setRestaurant(chef.getRestaurant());
                bean.setCity(chef.getCitta());
                bean.setIdChef(chef.getID());
                chefBeanResult.add(bean);
            }

            Setter.setChefList(chefBeanResult);
        }

    }

}

