package logic.appcontroller;

import logic.beans.Chefbean;
import logic.beans.Customerbean;
import logic.beans.Userbean;
import logic.dao.DAOChefImpl;
import logic.dao.DAOCustomerImpl;
import logic.model.Chef;
import logic.model.Customer;

public class SignupController {

    public void signup(Userbean user){
        if (user instanceof Customerbean){
            Customerbean cb = (Customerbean)user;
            DAOCustomerImpl cuDao = new DAOCustomerImpl();
            Customer cu = new Customer(-1,cb.getName().toUpperCase(),cb.getSurname().toUpperCase(), cb.getEmail(), cb.getPassword());
            cuDao.save(cu);
        }else if (user instanceof Chefbean){
            Chefbean chBean = (Chefbean)user;
            DAOChefImpl chDao = new DAOChefImpl();
            Chef ch = new Chef(-1,chBean.getName().toUpperCase(),chBean.getSurname().toUpperCase(), chBean.getEmail(), chBean.getPassword(), chBean.getRestaurant().toUpperCase(), chBean.getBestDish().toUpperCase(), chBean.getCitta().toUpperCase());
            chDao.save(ch);
        }else
            throw new IllegalArgumentException("User type not valid");


    }
}
