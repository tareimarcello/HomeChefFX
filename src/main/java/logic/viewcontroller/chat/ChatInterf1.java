package logic.viewcontroller.chat;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import logic.appcontroller.ChatController;
import logic.beans.SessionParamBean;
import logic.exceptions.ConnectionException;
import logic.exceptions.Exceptions;
import logic.model.Message;
import logic.pageswitch.PageMenu;
import logic.patterns.Decorator;
import logic.patterns.ViewSetter;

import java.util.List;

public class ChatInterf1 extends ChatViewController{
    private PageMenu pageswitch;
    @FXML
    private Text chefName;

    public ChatInterf1() {
        pageswitch = new PageMenu();
        graphics = new Decorator(true);
    }

    public void initialize() {

        if (this.currentChat!=null) {

            List<Message> messages = currentChat.getChatMessages();
            Label textmsg = null;

            for (Message mess : messages){
                this.graphics.setText(mess.getText());

                if (ViewSetter.getInstance().getSessionParam().getCurrentUserId()==mess.getSender()){

                    /* Visualizzare il messaggio come inviato */
                    textmsg=this.graphics.getMessageSended();

                }else if (ViewSetter.getInstance().getSessionParam().getCurrentUserId()==mess.getReceiver()) {

                    /* Visualizzare il messaggio come ricevuto */

                    textmsg=this.graphics.getMessageRecived();

                }else
                {
                    /** EXCEPTION MESSAGGIO dove l'utente corrente non compare ne come sender, ne come receiver **/
                }

                message.getChildren().add(textmsg);
                message.setPrefHeight(graphics.getAumenta());
                scrollpane.setVvalue(1.0);
                initializated=true;

            }

        }

    }

    @FXML
    protected void goBack(ActionEvent event) {
        ChatController controller = new ChatController();
        try {
            controller.refreshISC();
        } catch (ConnectionException e) {
            Exceptions.exceptionConnectionOccurred();
        }
        SessionParamBean.userType type = ViewSetter.getInstance().getSessionParam().getUserType();
        if(ViewSetter.getInstance().getIsHomeVisitBean()!=null && ViewSetter.getInstance().getIsHomeVisitBean().isHome()){
            pageswitch.backTo();
        }
        else if(type==SessionParamBean.userType.CHEF){
           pageswitch.switchToISCChef(event);
       }
       else{
           pageswitch.switchToISCUser(event);
       }
    }

    @FXML
    protected void goToHome(ActionEvent event) {
        pageswitch.switchToHome(event);
    }
    @FXML
    protected void goToBook(ActionEvent event) {
        pageswitch.switchToBookList(event);
    }
    @FXML
    protected void goToHomeChef(ActionEvent event){
        pageswitch.switchToHomeChef(event);
    }
    @FXML
    protected void goToBookListChef(ActionEvent event){
        //to be implemented
    }
}
