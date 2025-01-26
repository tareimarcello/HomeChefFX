package logic.viewcontroller.visithomechef;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import logic.appcontroller.VisitHomeChefController;
import logic.beans.SessionParamBean;
import logic.pageswitch.PageMenu;
import logic.patterns.Setter;

public class VisitHomeChefViewControllerInterf1 extends VisitHomeChefViewController{

    @FXML
    protected Button buttonBook;

    public VisitHomeChefViewControllerInterf1() {
        pageSwitch = new PageMenu();
        controller = new VisitHomeChefController();
    }

    public void initialize(){
        if(Setter.getSessionParam().getBookNot() && Setter.getSessionParam().getUserType()== SessionParamBean.UserType.CUSTOMER){
            buttonBook.setOpacity(1.0);
        }else{
            buttonBook.setOpacity(0.5);
        }
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
    @Override
    protected void goToChefChat(ActionEvent event){

        launchController();
        pageSwitch.switchTo("chatuser/interf1.fxml",event,"Chef Chat");
    }

    @FXML
    @Override
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
