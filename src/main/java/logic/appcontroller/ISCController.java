package logic.appcontroller;

import logic.beans.ReturnChefBean;
import logic.dao.DAOChefImpl;
import logic.exceptions.ConnectionException;
import logic.homechefutil.HomeChefUtil;
import logic.beans.ISCBean;
import logic.dao.DAOChatImpl;
import logic.dao.DAOMessageImpl;
import logic.model.Chat;
import logic.model.Message;
import logic.patterns.Setter;

import java.util.ArrayList;
import java.util.List;

public class ISCController {

    public List<ISCBean> getISCToUser() throws ConnectionException {

        /** Recupero chat dove lo chef è l'utente corrente **/

        DAOChatImpl chatDao = new DAOChatImpl();
        DAOMessageImpl messDao = new DAOMessageImpl();
        List<Chat> chatList = chatDao.getAllChatByChef(Setter.getSessionParam().getCurrentUserId());
        List<ISCBean> iscBeanList = new ArrayList<>();

        /** Per ogni chat recupero messaggi **/

        for (Chat chat : chatList){


            List<Message> messages = messDao.getAllByChat(chat.getId());
            ISCBean iscBean = new ISCBean();
            iscBean.setChat(chat);
            iscBean.setDestUser(HomeChefUtil.getCustByID(chat.getCustomer()));
            iscBean.getChatMessages().addAll(messages);
            iscBeanList.add(iscBean);

        }

        return iscBeanList;

    }

    public List<ISCBean> getISCToChef() throws ConnectionException {

        /** Recupero chat dove il customer è l'utente corrente **/
        DAOChatImpl chatDao = new DAOChatImpl();
        DAOMessageImpl messDao = new DAOMessageImpl();
        List<Chat> chatList = chatDao.getAllChatByCust(Setter.getSessionParam().getCurrentUserId());
        List<ISCBean> iscBeanList = new ArrayList<>();

        /** Per ogni chat recupero messaggi **/

        for (Chat chat : chatList){

            List<Message> messages = messDao.getAllByChat(chat.getId());
            ISCBean iscBean = new ISCBean();
            iscBean.setChat(chat);
            iscBean.setDestUser(HomeChefUtil.getChefById(chat.getChef()));
            iscBean.getChatMessages().addAll(messages);
            iscBeanList.add(iscBean);

        }

        return iscBeanList;

    }

    public Message getLastChatMessage (ISCBean chat) throws ConnectionException{

        DAOMessageImpl daoMsg = new DAOMessageImpl();
        List<Message> messages = daoMsg.getAllByChat(chat.getChat().getId());

        return messages.getLast();

    }

    public ReturnChefBean getChefVisit(ISCBean bean) throws ConnectionException {
        DAOChefImpl dao = new DAOChefImpl();
        ReturnChefBean retBean = new ReturnChefBean();
        retBean.setRetChef(dao.get(bean.getDestUser().getID()));
        return retBean;
    }

}
