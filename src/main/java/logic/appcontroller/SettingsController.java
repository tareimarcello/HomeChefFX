package logic.appcontroller;

import logic.beans.UpdatePswdBean;
import logic.dao.DAOUserImpl;
import logic.exceptions.ConnectionException;
import logic.exceptions.SamePasswordException;
import logic.model.User;

public class SettingsController {

    public void updatePswd(UpdatePswdBean bean) throws ConnectionException, SamePasswordException {
        DAOUserImpl dao = new DAOUserImpl();
        User user = dao.get(bean.getUserId());
        if(bean.getPswd().equals(user.getPassword())){
            throw new SamePasswordException("The password cannot be the same ");
        }
        dao.updatePswd(bean);
    }
}
