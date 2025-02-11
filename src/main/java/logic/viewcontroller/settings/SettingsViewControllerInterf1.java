package logic.viewcontroller.settings;

import logic.appcontroller.EditProfileController;
import logic.pageswitch.PageMenu;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public  class SettingsViewControllerInterf1 extends SettingViewController {

    public void initialize(){
      resetOpMsg();
    }

    public SettingsViewControllerInterf1(){
        pageSwitch=new PageMenu();
        controller = new EditProfileController();
    }

    @FXML
    protected void goToChat(ActionEvent event){

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
