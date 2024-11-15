package logic.viewcontroller.settings.settingschef;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import logic.viewcontroller.settings.SettingViewController;
import logic.viewcontroller.settings.settingscustomer.SettingsViewControllerInterf1;

public class SettingsChefViewController1 extends SettingViewController {

    public void initialize(){
        errMsg.setOpacity(0.0);
        rightMsg.setOpacity(0.0);
    }

    @FXML
    protected void goEditRestaurant(){
        //to be implemented
    }

    @Override
    protected void goBack() {
        //to be implemented
    }

    @Override
    protected void signOut(ActionEvent event) {
        //to be implemented
    }
}
