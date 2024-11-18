package logic.viewcontroller.chat;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import logic.appcontroller.ChatController;
import logic.beans.SessionParamBean;
import logic.exceptions.ConnectionException;
import logic.exceptions.Exceptions;
import logic.pageswitch.PageMenu;
import logic.patterns.Decorator;
import logic.patterns.ViewSetter;

public class ChatInterf1 extends ChatViewController{

    public ChatInterf1() {
        pageswitch = new PageMenu();
        graphics = new Decorator(true);
    }

    @FXML
    protected void goBack(ActionEvent event) {
        ChatController controller = new ChatController();
        try {
            controller.refreshISC();
        } catch (ConnectionException e) {
            Exceptions.exceptionConnectionOccurred();
        }
        SessionParamBean.UserType type = ViewSetter.getSessionParam().getUserType();
        if(ViewSetter.getIsHomeVisitBean()!=null && ViewSetter.getIsHomeVisitBean().isHome()){
            ViewSetter.getIsHomeVisitBean().setHome(false);
            pageswitch.backTo();
        }
        else if(type== SessionParamBean.UserType.CHEF){
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
