package logic.viewcontroller.chat;

import javafx.fxml.FXML;
import javafx.scene.text.Text;
import logic.appcontroller.ChatController;
import logic.exceptions.ConnectionException;
import logic.exceptions.Exceptions;
import logic.pageswitch.PageMenu;
import logic.patterns.Decorator;

public class ChatInterf2 extends ChatViewController{
    public ChatInterf2() {
        pageswitch = new PageMenu();
        graphics = new Decorator(false);
    }

    @FXML
    protected void sendMsgInterf2(){
        sendMsg();
        ChatController controller = new ChatController();
        try {
            controller.refreshISC();
        } catch (ConnectionException e) {
            Exceptions.exceptionConnectionOccurred();
        }
    }

}
