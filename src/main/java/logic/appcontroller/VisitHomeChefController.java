package logic.appcontroller;

import logic.beans.HomeChefBean;
import logic.beans.ISCBean;
import logic.dao.DAOChatImpl;
import logic.dao.DAOChefImpl;
import logic.dao.DAOMessageImpl;
import logic.exceptions.ConnectionException;
import logic.model.Chat;
import logic.model.Message;
import logic.patterns.ViewSetter;

import java.util.List;

public class VisitHomeChefController {

    public void loadChat(HomeChefBean chefBean) throws ConnectionException {

        /**
         * Verifico se ho già una chat attiva tra utente e chef **/

        DAOChatImpl daoChat = new DAOChatImpl();
        List<Chat> chatList = daoChat.getChatByCustChef(ViewSetter.getInstance().getSessionParam().getCurrentUserId(),chefBean.getId());
        if (!chatList.isEmpty()){

            Chat currentChat = chatList.getFirst();
            List<Message> messages = new DAOMessageImpl().getAllByChat(currentChat.getId());
            ISCBean chatBean = new ISCBean();
            chatBean.setChat(currentChat);
            chatBean.setDestUser(new DAOChefImpl().get(chefBean.getId()));
            chatBean.getChatMessages().addAll(messages);
            ViewSetter.getInstance().setOpenChat(chatBean);

        }else
            ViewSetter.getInstance().setOpenChat(null);

    }

}
