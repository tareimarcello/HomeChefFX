package logic.appcontroller;

import logic.beans.EditChefProfileBean;
import logic.beans.EditProfileBean;
import logic.dao.DAOChefImpl;
import logic.dao.DAOUserImpl;
import logic.exceptions.*;
import logic.model.Chef;
import logic.model.User;

import java.util.List;

public class SettingsController {

    public void updatePswd(EditProfileBean bean) throws ConnectionException, SamePasswordException {
        DAOUserImpl dao = new DAOUserImpl();
        User user = dao.get(bean.getUserId());
        if(bean.getPswd().equals(user.getPassword())){
            throw new SamePasswordException("The password cannot be the same ");
        }
        dao.updatePswd(bean);
    }

    public void updateMail(EditProfileBean bean) throws ConnectionException,MailUsedException,SameEmailException {
        DAOUserImpl dao = new DAOUserImpl();
        User user = dao.get(bean.getUserId());
        if(bean.getEmail().equals(user.getEmail())){
            throw new SameEmailException("The email cannot be the same ");
        }
        List<String> mailList = dao.getUsersMail();
        for(String index : mailList){
            if(index.equals(bean.getEmail())){
                throw new MailUsedException("Mail is already used");
            }
        }
        dao.updateMail(bean);
    }

    public void updateRes(EditChefProfileBean bean) throws ConnectionException, SameResException {
        DAOChefImpl dao = new DAOChefImpl();
        Chef chef = dao.get(bean.getUserId());
        if(bean.getRes().equals(chef.getRestaurant())){
            throw new SameResException("The restaurant cannot be the same ");
        }
        chef.setRestaurant(bean.getRes());
        dao.update(chef);
    }
}
