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
    protected void sendMsg() {

        recivemsgArr();
        MessageBean msgBean = new MessageBean();
        SessionParamBean sessionParam = ViewSetter.getInstance().getSessionParam();

        msgBean.setIdChat(this.currentChat.getChat().getId());
        msgBean.setIdSender(sessionParam.getCurrentUserId());
        msgBean.setIdReceiver(this.currentChat.getDestUser().getID());
        msgBean.setText(inputmsg.getText());

        ChatController chat = new ChatController();
        chat.saveMessage(msgBean);

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
