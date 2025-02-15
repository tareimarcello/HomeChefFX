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
import logic.model.User;
import logic.patterns.factory.FactoryUser;

import java.util.List;


public class SignupController {

    public void signup(Userbean user) throws ConnectionException, MailAlreadyUsed {
        FactoryUser factory = new FactoryUser();
        DAOUserImpl dao = new DAOUserImpl();
        int i=0;
            List<String> mail = dao.getUsersMail();
            while(i<mail.size() && !user.getEmailBean().equals(mail.get(i))) {
                i++;
            }
            if (i<mail.size()) {
                throw new MailAlreadyUsed("Mail is already used");
            }

            switch (user) {
                case Customerbean cb -> {
                    DAOCustomerImpl cuDao = new DAOCustomerImpl();
                    User cu = factory.createCustomer(-1, cb.getNameBean().toUpperCase(), cb.getSurnameBean().toUpperCase()
                            ,false);
                    cuDao.save((Customer)cu,cb.getEmailBean(),cb.getPasswordBean());
                }
                case Chefbean chB -> {
                    DAOChefImpl chDao = new DAOChefImpl();
                   User ch = factory.createChef(-1, chB.getNameBean().toUpperCase(), chB.getSurnameBean().toUpperCase(),
                            chB.getRestaurant().toUpperCase(),
                            chB.getBestDish().toUpperCase(),
                            chB.getCitta().toUpperCase());
                    chDao.save((Chef)ch,chB.getEmailBean(),chB.getPasswordBean());
                }
                default -> throw new IllegalArgumentException("User type not valid");
            }

    }

}
