package logic.appcontroller;

import logic.beans.ResultSearchBean;
import logic.beans.SearchBean;
import logic.dao.DAOChefImpl;
import logic.exceptions.ConnectionException;
import logic.exceptions.NoResultFoundException;
import logic.model.User;
import logic.patterns.Setter;
import java.util.ArrayList;
import java.util.List;

public class SearchController {


    public void searchChefList(SearchBean chefBean) throws ConnectionException, NoResultFoundException {

        DAOChefImpl daoChef = new DAOChefImpl();
        List<User> chefListResult = daoChef.getChefByParam(chefBean);
        List<ResultSearchBean> chefBeanResult = new ArrayList<>();
        if(chefListResult.isEmpty()) {
            throw new NoResultFoundException("No results found");
        }else {
            for (User chef : chefListResult) {

                ResultSearchBean bean = new ResultSearchBean();
                bean.setNameChef(chef.getName() + " " + chef.getSurname());
                bean.setBestDish((String)chef.getInfo(1));
                bean.setRestaurant((String)chef.getInfo(0));
                bean.setCity((String)chef.getInfo(2));
                bean.setIdChef(chef.getID());
                chefBeanResult.add(bean);
            }

            Setter.setChefList(chefBeanResult);
        }

    }

}

