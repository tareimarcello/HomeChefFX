package logic.viewcontroller.settings;

import logic.appcontroller.EditProfileController;
import logic.homechefutil.HomeChefUtil;
import logic.pageswitch.PageMenu;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;


public  class SettingsViewControllerInterf2 extends SettingViewController {
    @FXML
    protected AnchorPane buttonBar;

    public SettingsViewControllerInterf2(){
        pageSwitch=new PageMenu();
        controller = new EditProfileController();
    }

    public void initialize(){
        errMsg.setOpacity(0.0);
        rightMsg.setOpacity(0.0);
        HomeChefUtil.linkButtonBarInterf2(buttonBar);
    }
    @FXML
    @Override
    protected void goBack(){
        pageSwitch.backTo();
    }
    @FXML
    @Override
    protected void signOut(ActionEvent event){
        pageSwitch.switchTo("login/interf2.fxml",event,"Login");
    }
}
