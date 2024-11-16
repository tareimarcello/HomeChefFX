package logic.appcontroller;

import logic.beans.RecPswdBean;
import logic.dao.DAOUserImpl;
import logic.exceptions.ConnectionException;
import logic.exceptions.MailNotInDBException;

import java.util.List;

public class RecPswdController {

    public void checkEmail(RecPswdBean bean) throws ConnectionException {
        DAOUserImpl dao = new DAOUserImpl();
        List<String> mailList= dao.getUsersMail();
        int i=0;
        while(i<mailList.size() && !mailList.get(i).equals(bean.getEmail())) {
            System.out.println("Valore indice i :" + i);
            i++;
        }
        System.out.println("Lunghezze lista " + mailList.size());
        if(mailList.size()==i){
            throw new MailNotInDBException("Mail not in database");
        }
    }
}
