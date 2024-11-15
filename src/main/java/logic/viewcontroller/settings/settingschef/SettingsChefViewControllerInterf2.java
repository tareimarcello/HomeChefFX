package logic.viewcontroller.settings.settingschef;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import logic.HomeChefApplication;
import logic.homechefutil.HomeChefUtil;
import logic.viewcontroller.settings.SettingViewController;
import logic.viewcontroller.settings.settingscustomer.SettingsViewControllerInterf2;

import java.io.IOException;

public class SettingsChefViewControllerInterf2 extends SettingViewController {
    @FXML
    private AnchorPane buttonBar;

    public void initialize(){
        errMsg.setOpacity(0.0);
        rightMsg.setOpacity(0.0);
        HomeChefUtil.linkButtonBarInterf2(buttonBar);
    }
    @FXML
    protected void goEditRestaurant() {
        //to be implemented
    }

    @Override
    protected void goBack() {
        //To be implemented
    }

    @Override
    protected void signOut(ActionEvent event) {
        //to be implemented
    }
}
