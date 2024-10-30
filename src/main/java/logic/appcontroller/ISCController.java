package logic.appcontroller;

import logic.HomeChefUtil;
import logic.beans.ISCBean;
import logic.dao.DAOChatImpl;
import logic.dao.DAOMessageImpl;
import logic.model.Chat;
import logic.model.Message;
import logic.patterns.ViewSetter;

import java.util.ArrayList;
import java.util.List;

public class ISCController {

    public List<ISCBean> getISCToUser(){

        /** Recupero chat dove lo chef è l'utente corrente **/

        DAOChatImpl chatDao = new DAOChatImpl();
        DAOMessageImpl messDao = new DAOMessageImpl();
        List<Chat> chatList = chatDao.getAllChatByChef(ViewSetter.getInstance().getSessionParam().getCurrentUserId());
        List<ISCBean> iscBeanList = new ArrayList<>();

        /** Per ogni chat recupero messaggi **/

        for (Chat chat : chatList){

            List<Message> messages = messDao.getAllByChat(chat.getId());
            ISCBean iscBean = new ISCBean();
            iscBean.setChat(chat);
            iscBean.setDestUser(HomeChefUtil.getUserByID(chat.getCustomer()));
            iscBean.getChatMessages().addAll(messages);
            iscBeanList.add(iscBean);

        }

        return iscBeanList;

    }

    public List<ISCBean> getISCToChef(){

        /** Recupero chat dove il customer è l'utente corrente **/
        DAOChatImpl chatDao = new DAOChatImpl();
        DAOMessageImpl messDao = new DAOMessageImpl();
        List<Chat> chatList = chatDao.getAllChatByCust(ViewSetter.getInstance().getSessionParam().getCurrentUserId());
        List<ISCBean> iscBeanList = new ArrayList<>();

        /** Per ogni chat recupero messaggi **/

        for (Chat chat : chatList){

            List<Message> messages = messDao.getAllByChat(chat.getId());
            ISCBean iscBean = new ISCBean();
            iscBean.setChat(chat);
            iscBean.setDestUser(HomeChefUtil.getUserByID(chat.getChef()));
            iscBean.getChatMessages().addAll(messages);
            iscBeanList.add(iscBean);

        }

        return iscBeanList;

    }



    private List<Message>  getAllChatMessage (long chatId){

        /** Chiamo DAO per recuperare la lista dei messaggi con il chat id passato in Input **/


        return null;

    }




}
