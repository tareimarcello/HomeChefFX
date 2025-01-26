package logic.appcontroller;

import logic.dao.DAOCustomerImpl;
import logic.exceptions.ConnectionException;
import logic.patterns.Setter;

public class ButtonBarController {

    public void changeNot() throws ConnectionException {
        DAOCustomerImpl dao = new DAOCustomerImpl();
        dao.setCustomerNot(Setter.getSessionParam().getCurrentUserId(),false);
        Setter.getSessionParam().setBookNot(false);
    }
}
