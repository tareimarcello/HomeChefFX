package logic.appcontroller;

import logic.beans.Logbean;
import logic.beans.ReturnLoginBean;
import logic.dao.DAOChefImpl;
import logic.dao.DAOCustomerImpl;
import logic.dao.DAOUserImpl;
import logic.exceptions.LoginErrorException;
import logic.model.User;

import java.util.NoSuchElementException;

public class LoginController {


    public ReturnLoginBean loginUser(Logbean userBean) throws Exception {

        DAOUserImpl userDao = new DAOUserImpl();
        User user = userDao.verifyLogin(userBean);
        if (!user.getPassword().equals(userBean.getPassword())){

            throw new LoginErrorException(" password is not valid");
        }
        ReturnLoginBean retBean = new ReturnLoginBean();
        retBean.setReturnUser(user);
        return retBean;
    }

    public ReturnLoginBean checkType(long id) throws Exception {

        DAOCustomerImpl cDAO = new DAOCustomerImpl();
        DAOChefImpl chDAO = new DAOChefImpl();
        User user;
        try {
            user = cDAO.get(id);
        }catch(NoSuchElementException e){
            user = chDAO.get(id);
        }
        ReturnLoginBean retBean = new ReturnLoginBean();
        retBean.setReturnUser(user);
        return retBean;
    }
}
