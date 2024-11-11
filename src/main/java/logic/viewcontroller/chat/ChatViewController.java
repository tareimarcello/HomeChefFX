package logic.viewcontroller.chat;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import logic.appcontroller.ChatController;
import logic.beans.ISCBean;
import logic.beans.MessageBean;
import logic.beans.SessionParamBean;
import logic.dao.DAOChatImpl;
import logic.exceptions.ConnectionException;
import logic.exceptions.Exceptions;
import logic.model.Chat;
import logic.pageswitch.PageMenu;
import logic.patterns.Decorator;
import logic.patterns.ViewSetter;

public abstract class ChatViewController {
    private PageMenu pageswitch;
    @FXML
    private TextArea inputmsg;
    @FXML
    protected AnchorPane message;
    @FXML
    protected ScrollPane scrollpane;
    protected Decorator graphics;
    protected  boolean initializated;

    protected ISCBean currentChat;

    protected ChatViewController() {
        pageswitch = new PageMenu();
        initializated = false;
        currentChat = ViewSetter.getInstance().getOpenChat();

    }
    @FXML
    protected void sendMsg(){

        recivemsgArr();
        MessageBean msgBean = new MessageBean();
        ChatController chat = new ChatController();
        SessionParamBean sessionParam = ViewSetter.getInstance().getSessionParam();
        /** Creazione chat se è il primo messaggio scambiato tra chef e utente **/

        if (currentChat.getChat().getId()<0) {

            try{

                currentChat=chat.createChat(this.currentChat);

            }catch (ConnectionException e){

                Exceptions.exceptionConnectionOccurred();
            }

        }

        msgBean.setIdChat(this.currentChat.getChat().getId());
        msgBean.setIdSender(sessionParam.getCurrentUserId());
        msgBean.setIdReceiver(this.currentChat.getDestUser().getID());
        msgBean.setText(inputmsg.getText());

        try {
            chat.saveMessage(msgBean);
        } catch (ConnectionException e) {
            Exceptions.exceptionConnectionOccurred();
        }

    }

    public void recivemsgArr() {
        String messageTry = inputmsg.getText();         //prova per vedere se funziona la chat senza controller applicativo altra
        //parte di controllo da aggiungere
        Label textmsg;
        graphics.setText(messageTry);
        textmsg = graphics.getMessageSended();
        message.getChildren().add(textmsg);
        message.setPrefHeight(graphics.getAumenta());
        scrollpane.setVvalue(1.0);
        initializated=true;
    }
}
