package logic.viewController.settings;

import logic.pageSwitch.PageMenu;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class SettingsViewControllerInterf1 {
    private PageMenu pageSwitch;
    @FXML
    private TextField email;
    @FXML
    private TextField pswd;
    @FXML
    private TextField confirmpswd;


    public SettingsViewControllerInterf1(){
        pageSwitch=new PageMenu();
    }

    @FXML
    protected void goToChat(ActionEvent event){

    }
    @FXML
    protected void goToHome(ActionEvent event){
        pageSwitch.switchToHome(event);
    }
    @FXML
    protected void goBack(){
        pageSwitch.backTo();
    }
    @FXML
    protected void goEditProf(){

    }
    @FXML
    protected void setPswd(){

    }
    @FXML
    protected void signOut(ActionEvent event){
        pageSwitch.switchTo("login/interf1.fxml",event,"Login");
    }
    @FXML
    protected void setMail(){

    }
    @FXML
    protected void setFeed(){

    }
}
