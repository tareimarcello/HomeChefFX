package logic.appcontroller;

import logic.beans.Logbean;
import logic.dao.DAOChefImpl;
import logic.dao.DAOCustomerImpl;
import logic.dao.DAOUserImpl;
import logic.model.User;

import java.util.NoSuchElementException;

public class LoginController {

    public User loginUser(Logbean userBean) throws Exception{

        DAOUserImpl userDao = new DAOUserImpl();
        User user = userDao.verifyLogin(userBean);

        if (!user.getPassword().equals(userBean.getPassword())){

            throw new Exception(" password is not valid");
        }

        return user;
    }

    public User checkType(long id){

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
