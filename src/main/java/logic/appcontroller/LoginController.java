package logic.appcontroller;

import logic.beans.HomeChefBean;
import logic.beans.Logbean;
import logic.beans.ReturnLoginBean;
import logic.beans.SessionParamBean;
import logic.dao.DAOChefImpl;
import logic.dao.DAOCustomerImpl;
import logic.dao.DAOUserImpl;
import logic.exceptions.ConnectionException;
import logic.exceptions.LoginErrorException;
import logic.model.Chef;
import logic.model.Customer;
import logic.model.User;
import logic.patterns.Setter;

import java.util.NoSuchElementException;

public class LoginController {


    public ReturnLoginBean loginUser(Logbean userBean) throws ConnectionException,LoginErrorException {
        /*
        DAOUserImpl userDao = new DAOUserImpl();

        User user = userDao.verifyLogin(userBean);
        if (user == null) {
            throw new LoginErrorException(" password or email is not valid");
        }

         */
        DAOUserImpl daoUser = new DAOUserImpl();
        long id = daoUser.getId(userBean.getEmail(), userBean.getPassword());
        SessionParamBean sessionParam = new SessionParamBean();
        sessionParam.setCurrentUserId(id);
        Setter.setSessionParam(sessionParam);
        User user = this.checkType(id);
        // - aprire la pagina corretta
        switch (user) {
            case Customer cu -> {
                Setter.getSessionParam().setUserType(SessionParamBean.UserType.CUSTOMER);
                Setter.getSessionParam().setBookNot(cu.getBookNot());
            }
            case Chef ch -> {
                HomeChefBean hcbean = new HomeChefBean();
                hcbean.setName(user.getName() + " " + user.getSurname());
                hcbean.setCity(ch.getCitta());
                hcbean.setDish(ch.getBestDish());
                hcbean.setRes(ch.getRestaurant());
                hcbean.setId(ch.getID());
                Setter.setHcbean(hcbean);
                Setter.getSessionParam().setUserType(SessionParamBean.UserType.CHEF);
            }
            default -> throw new IllegalArgumentException("User type not valid");
        }
        ReturnLoginBean retBean = new ReturnLoginBean();

        retBean.setReturnUser(user);
        return retBean;
    }

    private User checkType(long id) throws ConnectionException {

        DAOCustomerImpl cDAO = new DAOCustomerImpl();
        DAOChefImpl chDAO = new DAOChefImpl();
        User user;
        try {
            user = cDAO.get(id);
        }catch(NoSuchElementException e){
            user = chDAO.get(id);
        }
        return user;
    }
}
