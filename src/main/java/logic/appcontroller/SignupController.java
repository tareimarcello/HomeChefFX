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
        if (user instanceof Customerbean cb){
            DAOCustomerImpl cuDao = new DAOCustomerImpl();
            Customer cu = new Customer(-1,cb.getNameBean().toUpperCase(),cb.getSurnameBean().toUpperCase(), cb.getEmailBean(), cb.getPasswordBean());
            cuDao.save(cu);
        }else if (user instanceof Chefbean chB){
            DAOChefImpl chDao = new DAOChefImpl();
            Chef ch = new Chef(-1,chB.getNameBean().toUpperCase(),chB.getSurnameBean().toUpperCase(), chB.getEmailBean(), chB.getPasswordBean(), chB.getRestaurant().toUpperCase(), chB.getBestDish().toUpperCase(), chB.getCitta().toUpperCase());
            chDao.save(ch);
        }else
            throw new IllegalArgumentException("User type not valid");


    }
}
