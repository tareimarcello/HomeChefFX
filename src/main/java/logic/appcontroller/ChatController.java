package logic.appcontroller;

import logic.beans.ISCBean;
import logic.beans.MessageBean;
import logic.beans.SessionParamBean;
import logic.dao.DAOChatImpl;
import logic.dao.DAOMessageImpl;
import logic.exceptions.ConnectionException;
import logic.model.Chat;
import logic.model.Message;
import logic.patterns.ViewSetter;

import java.sql.Timestamp;
import java.util.List;

public class ChatController {


    public void saveMessage(MessageBean messageBean) throws ConnectionException {

        DAOMessageImpl msgDao = new DAOMessageImpl();
        Message msg = new Message(-1,messageBean.getIdSender(), messageBean.getIdReceiver(), messageBean.getText(), new Timestamp(System.currentTimeMillis()), messageBean.getIdChat());
        msgDao.save(msg);

    }

    public ISCBean createChat(ISCBean chatBean) throws ConnectionException{

        DAOChatImpl chatDao = new DAOChatImpl();
        chatDao.save(chatBean.getChat());

        List<Chat> newChat = chatDao.getChatByCustChef(chatBean.getChat().getCustomer(),chatBean.getChat().getChef());
        if (!newChat.isEmpty()){
            chatBean.setChat(newChat.getFirst());
            ViewSetter.getInstance().setOpenChat(chatBean);
        }
        return chatBean;
    }

    public void refreshISC() throws ConnectionException{

        SessionParamBean.userType type = ViewSetter.getInstance().getSessionParam().getUserType();

        ISCController ISCController = new ISCController();

        if (type==SessionParamBean.userType.CUSTOMER){

            ViewSetter.getInstance().setChatList(ISCController.getISCToChef());

        }else {

            ViewSetter.getInstance().setChatList(ISCController.getISCToUser());

        }

    }
}
