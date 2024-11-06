package logic.appcontroller;

import logic.beans.MessageBean;
import logic.dao.DAOMessageImpl;
import logic.exceptions.ConnectionException;
import logic.model.Message;

import java.sql.Timestamp;

public class ChatController {


    public void saveMessage(MessageBean messageBean) throws ConnectionException {

        DAOMessageImpl msgDao = new DAOMessageImpl();
        Message msg = new Message(-1,messageBean.getIdSender(), messageBean.getIdReceiver(), messageBean.getText(), new Timestamp(System.currentTimeMillis()), messageBean.getIdChat());
        msgDao.save(msg);

    }

}
