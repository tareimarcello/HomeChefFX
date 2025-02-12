package logic.appcontroller;

import logic.beans.Chefbean;
import logic.beans.Customerbean;
import logic.beans.Userbean;
import logic.dao.DAOChefImpl;
import logic.dao.DAOCustomerImpl;
import logic.dao.DAOUserImpl;
import logic.exceptions.ConnectionException;
import logic.exceptions.MailAlreadyUsed;
import logic.model.Chef;
import logic.model.Customer;
import logic.patterns.factory.FactoryUser;

import java.util.NoSuchElementException;

public class SignupController {

    public void signup(Userbean user) throws ConnectionException, MailAlreadyUsed {
        FactoryUser factory = new FactoryUser();
        DAOUserImpl dao = new DAOUserImpl();
        try {
            if (dao.getUserBYMail(user.getEmailBean()) != null) {
                throw new MailAlreadyUsed("Mail is already used");
            }
        } catch (NoSuchElementException e) {

            switch (user) {
                case Customerbean cb -> {
                    DAOCustomerImpl cuDao = new DAOCustomerImpl();
                    Customer cu = factory.createCustomer(-1, cb.getNameBean().toUpperCase(), cb.getSurnameBean().toUpperCase()
                            ,false);
                    cuDao.save(cu,cb.getEmailBean(),cb.getPasswordBean());
                }
                case Chefbean chB -> {
                    DAOChefImpl chDao = new DAOChefImpl();
                    Chef ch = factory.createChef(-1, chB.getNameBean().toUpperCase(), chB.getSurnameBean().toUpperCase(),
                            chB.getRestaurant().toUpperCase(),
                            chB.getBestDish().toUpperCase(),
                            chB.getCitta().toUpperCase());
                    chDao.save(ch,chB.getEmailBean(),chB.getPasswordBean());
                }
                default -> throw new IllegalArgumentException("User type not valid");
            }
        }
    }
}
