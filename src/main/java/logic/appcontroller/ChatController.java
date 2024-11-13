package logic.appcontroller;

import logic.beans.ISCBean;
import logic.beans.MessageBean;
import logic.beans.SessionParamBean;
import logic.dao.DAOChatImpl;
import logic.dao.DAOMessageImpl;
import logic.exceptions.ConnectionException;
import logic.homechefutil.HomeChefUtil;
import logic.model.Chat;
import logic.model.Message;
import logic.patterns.ViewSetter;

import java.sql.Timestamp;
import java.util.ArrayList;
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

        long idUser = ViewSetter.getInstance().getSessionParam().getCurrentUserId();
        SessionParamBean.userType type = ViewSetter.getInstance().getSessionParam().getUserType();
        DAOChatImpl daoChat =new DAOChatImpl();
        DAOMessageImpl messDao = new DAOMessageImpl();
        List<ISCBean> iscBeanList = new ArrayList<>();
        List<Chat> chatListUpdated = new ArrayList<>();
        if (type==SessionParamBean.userType.CUSTOMER){

            chatListUpdated.addAll(daoChat.getAllChatByCust(idUser));

        }else {

            chatListUpdated.addAll(daoChat.getAllChatByChef(idUser));

        }

        /** Per ogni chat recupero messaggi **/

        for (Chat chat : chatListUpdated){

            List<Message> messages = messDao.getAllByChat(chat.getId());
            ISCBean iscBean = new ISCBean();
            iscBean.setChat(chat);
            iscBean.setDestUser(HomeChefUtil.getUserByID(chat.getCustomer()));
            iscBean.getChatMessages().addAll(messages);
            iscBeanList.add(iscBean);

        }

        ViewSetter.getInstance().setChatList(iscBeanList);
    }

}
