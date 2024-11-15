package logic.viewcontroller.settings.settingscustomer;

import logic.HomeChefApplication;
import logic.pageswitch.PageMenu;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import logic.viewcontroller.settings.SettingViewController;

import java.io.IOException;

public  class SettingsViewControllerInterf2 extends SettingViewController {
    private PageMenu pageSwitch;
    @FXML
    private AnchorPane buttonBar;



    public SettingsViewControllerInterf2(){
        pageSwitch=new PageMenu();
    }

    public void initialize(){
        errMsg.setOpacity(0.0);
        rightMsg.setOpacity(0.0);
        try {
            buttonBar.getChildren().removeAll(buttonBar.getChildren());
            buttonBar.getChildren().add((Node) FXMLLoader.load(HomeChefApplication.class.getResource("buttonBarInterf2.fxml")));
        } catch (IOException e) {
            buttonBar.getChildren().removeAll(buttonBar.getChildren());
        }
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
