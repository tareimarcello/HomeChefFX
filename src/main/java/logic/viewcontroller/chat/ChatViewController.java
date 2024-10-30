package logic.viewcontroller.chat;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import logic.appcontroller.ChatController;
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
    private AnchorPane message;
    @FXML
    private ScrollPane scrollpane;
    protected Decorator graphics;
    protected  boolean initializated;

    public ChatViewController() {
        pageswitch = new PageMenu();
        initializated = false;
    }
    @FXML
    protected void sendMsg() {

        recivemsgArr();
        MessageBean msgBean = new MessageBean();
        SessionParamBean sessionParam = ViewSetter.getInstance().getSessionParam();

        msgBean.setIdChat(sessionParam.getCurrentChatId());
        msgBean.setIdSender(sessionParam.getCurrentUserId());
        msgBean.setIdReceiver(sessionParam.getCurrentReceiverId());
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
