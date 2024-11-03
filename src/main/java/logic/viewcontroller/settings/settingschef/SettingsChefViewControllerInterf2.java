package logic.viewcontroller.settings.settingschef;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import logic.HomeChefApplication;
import logic.viewcontroller.settings.SettingViewController;
import logic.viewcontroller.settings.settingscustomer.SettingsViewControllerInterf2;

import java.io.IOException;

public class SettingsChefViewControllerInterf2 extends SettingViewController {
    @FXML
    private AnchorPane buttonBar;

    public void initialize(){
        try {
            buttonBar.getChildren().removeAll(buttonBar.getChildren());
            buttonBar.getChildren().add((Node) FXMLLoader.load(HomeChefApplication.class.getResource("buttonBarChefInterf2.fxml")));
        } catch (IOException e) {
            buttonBar.getChildren().removeAll(buttonBar.getChildren());
        }
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
