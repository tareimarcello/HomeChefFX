package logic.viewcontroller.settings.settingscustomer;

import logic.pageswitch.PageMenu;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import logic.viewcontroller.settings.SettingViewController;

public  class SettingsViewControllerInterf1 extends SettingViewController {
    private PageMenu pageSwitch;


    public SettingsViewControllerInterf1(){
        pageSwitch=new PageMenu();
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
