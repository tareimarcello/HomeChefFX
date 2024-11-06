package logic.viewcontroller.visithomechef;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import logic.appcontroller.VisitHomeChefController;
import logic.exceptions.ConnectionException;
import logic.exceptions.Exceptions;
import logic.pageswitch.PageMenu;

public class VisitHomeChefViewControllerInterf1 extends VisitHomeChefViewController{


    public VisitHomeChefViewControllerInterf1() {
        pageSwitch = new PageMenu();
    }

    public void initialize(){
        downLoadHcBean();
    }

    @FXML
    protected void backTo(){
        pageSwitch.backTo();
    }

    @FXML
    protected void goToSettings(ActionEvent event){
        pageSwitch.switchToSettings(event);
    }

    @FXML
    protected void goToChefChat(ActionEvent event){

        VisitHomeChefController controller = new VisitHomeChefController();
        try {
            controller.loadChat(this.hcbean);
        } catch (ConnectionException e) {
            Exceptions.exceptionConnectionOccurred();
        }
        pageSwitch.switchTo("chatuser/interf1.fxml",event,"Chef Chat");
    }

    @FXML
    protected void goToBookChef(ActionEvent event){
        pageSwitch.switchTo("clientbook/interf1.fxml",event,"Book Chef");
    }
    @FXML
    protected void goToBook(ActionEvent event){
        pageSwitch.switchToBookList(event);
    }
    @FXML
    protected void goToISC(ActionEvent event){
        pageSwitch.switchToISCUser(event);
    }
    @FXML
    protected void goToHome(ActionEvent event){
        pageSwitch.switchToHome(event);
    }
}
