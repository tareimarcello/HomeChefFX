package logic.viewcontroller.chat;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import logic.appcontroller.ChatController;
import logic.beans.ISCBean;
import logic.beans.IsHomeVisitBean;
import logic.beans.MessageBean;
import logic.beans.SessionParamBean;
import logic.exceptions.ConnectionException;
import logic.exceptions.Exceptions;
import logic.model.Message;
import logic.pageswitch.PageMenu;
import logic.patterns.Decorator;
import logic.patterns.Setter;

import java.util.List;

public class ChatViewController {
    protected ChatController controller;
    protected PageMenu pageswitch;
    @FXML
    private TextArea inputmsg;
    @FXML
    protected AnchorPane message;
    @FXML
    protected ScrollPane scrollpane;
    @FXML
    protected Text userName;
    protected Decorator graphics;
    protected  boolean initializated;

    protected ISCBean currentChat;

    protected ChatViewController() {
        pageswitch = new PageMenu();
        initializated = false;
        currentChat = Setter.getOpenChat();
        controller = new ChatController();

    }

    public void initialize() {

        if(Setter.getIsHomeVisitBean() == null){
            IsHomeVisitBean bean = new IsHomeVisitBean();
            bean.setHome(false);
            Setter.setIsHomeVisitBean(bean);
        }
        if (this.currentChat!=null) {
            this.userName.setText(currentChat.getDestUser().getName()+" "+currentChat.getDestUser().getSurname());
            List<Message> messages = currentChat.getChatMessages();
            Label textmsg = null;

            for (Message mess : messages){
                this.graphics.setText(mess.getText());

                if (Setter.getSessionParam().getCurrentUserId()==mess.getSender()){

                    /* Visualizzare il messaggio come inviato */
                    textmsg=this.graphics.getMessageSended();

                }else if (Setter.getSessionParam().getCurrentUserId()==mess.getReceiver()) {

                    /* Visualizzare il messaggio come ricevuto */

                    textmsg = this.graphics.getMessageRecived();

                }

                message.getChildren().add(textmsg);
                message.setPrefHeight(graphics.getAumenta());
                scrollpane.setVvalue(1.0);
                initializated=true;

            }

        }

    }

    @FXML
    protected void sendMsg(){
        String text = inputmsg.getText();
        if(text.isEmpty()){
            return ;
        }
        while(text.endsWith(" ")){
            text = text.substring(0, text.length()-1);
        }
        recivemsgArr();
        MessageBean msgBean = new MessageBean();
        SessionParamBean sessionParam = Setter.getSessionParam();
        /** Creazione chat se è il primo messaggio scambiato tra chef e utente **/

        if (currentChat.getChat().getId()<0) {

            try{

                currentChat=controller.createChat(this.currentChat);

            }catch (ConnectionException e){

                Exceptions.exceptionConnectionOccurred();
            }

        }

        msgBean.setIdChat(this.currentChat.getChat().getId());
        msgBean.setIdSender(sessionParam.getCurrentUserId());
        msgBean.setIdReceiver(this.currentChat.getDestUser().getID());
        msgBean.setText(text);

        try {
            controller.saveMessage(msgBean);
            if(Setter.getMode()== Setter.Mode.DESKTOP &&!Setter.getIsHomeVisitBean().isHome()) {
                Setter.getObserver().notifyMsgISC();
            }inputmsg.setText("");
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
