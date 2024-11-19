package logic.viewcontroller.settings;

import logic.appcontroller.ISCController;
import logic.exceptions.ConnectionException;
import logic.exceptions.Exceptions;
import logic.pageswitch.PageMenu;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import logic.patterns.ViewSetter;

public  class SettingsViewControllerInterf1 extends SettingViewController {

    public void initialize(){
      resetOpMsg();
    }

    public SettingsViewControllerInterf1(){
        pageSwitch=new PageMenu();
    }

    @FXML
    protected void goToChat(ActionEvent event){

        ISCController controller = new ISCController();
        try {
            ViewSetter.setChatList(controller.getISCToChef());
        } catch (ConnectionException e) {
            Exceptions.exceptionConnectionOccurred();
        }
        pageSwitch.switchToISCUser(event);
    }
    @FXML
    protected void goToHome(ActionEvent event){
        pageSwitch.switchToHome(event);
    }
    @FXML
    @Override
    protected void goBack(){
        pageSwitch.backTo();
    }
    @FXML
    @Override
    protected void signOut(ActionEvent event){
        pageSwitch.switchTo("login/interf1.fxml",event,"Login");
    }
}
