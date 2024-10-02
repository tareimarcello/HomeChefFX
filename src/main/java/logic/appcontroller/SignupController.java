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

            DAOCustomerImpl cuDao = new DAOCustomerImpl();
            Customer cu = new Customer(-1,user.getName(),user.getSurname(), user.getEmail(), user.getPassword());
            cuDao.save(cu);
        }else if (user instanceof Chefbean){
            DAOChefImpl chDao = new DAOChefImpl();
            Chef ch = new Chef(-1,user.getName(),user.getSurname(), user.getEmail(), user.getPassword(), ((Chefbean) user).getRestaurant(), ((Chefbean) user).getBestDish(), ((Chefbean) user).getCitta());
            chDao.save(ch);
        }else
            throw new IllegalArgumentException("User type not valid");


    }
    //ciao a ttui e tutte
}
