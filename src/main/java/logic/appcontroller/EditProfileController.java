package logic.appcontroller;

import logic.beans.EditChefProfileBean;
import logic.beans.EditProfileBean;
import logic.dao.DAOChefImpl;
import logic.dao.DAOUserImpl;
import logic.exceptions.*;
import logic.model.Chef;
import logic.patterns.Setter;

import java.util.List;

public class EditProfileController {

    public void updatePswd(EditProfileBean bean) throws ConnectionException, EditProfException {
        DAOUserImpl dao = new DAOUserImpl();
        String pswd = dao.getPswd(bean.getUserId());
        if(bean.getPswd().equals(pswd)){
            throw new EditProfException("The password cannot be the same ");
        }
        dao.updatePswd(bean);
    }

    public void updateMail(EditProfileBean bean) throws ConnectionException,EditProfException {
        DAOUserImpl dao = new DAOUserImpl();
        List<String> mailList = dao.getUsersMail();
        for(String index : mailList){
            if(index.equals(bean.getEmail())){
                throw new EditProfException("Mail is already used");
            }
        }
        dao.updateMail(bean);
    }

    public void updateRes(EditChefProfileBean bean) throws ConnectionException, EditProfException {
        DAOChefImpl dao = new DAOChefImpl();
        Chef chef = dao.get(bean.getUserId());
        if(bean.getRes().equals(chef.getRestaurant())){
            throw new EditProfException("The restaurant cannot be the same ");
        }
        chef.setRestaurant(bean.getRes());
        dao.update(chef);
        Setter.getHcbean().setRes(bean.getRes());
    }

    public void updateCity(EditChefProfileBean bean) throws ConnectionException, EditProfException{
        DAOChefImpl dao = new DAOChefImpl();
        Chef chef = dao.get(bean.getUserId());
        if(bean.getCity().equals(chef.getCitta())){
            throw new EditProfException("The city cannot be the same ");
        }
        chef.setCitta(bean.getCity());
        dao.update(chef);
        Setter.getHcbean().setRes(bean.getCity());
    }
}
