package logic.viewcontroller.settings;

import logic.HomeChefApplication;
import logic.pageswitch.PageMenu;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public  class SettingsViewControllerInterf2 {
    private PageMenu pageSwitch;
    @FXML
    private TextField email;
    @FXML
    private TextField pswd;
    @FXML
    private TextField confirmpswd;
    @FXML
    private AnchorPane buttonBar;


    public SettingsViewControllerInterf2(){
        pageSwitch=new PageMenu();
    }

    public void initialize(){
        try {
            buttonBar.getChildren().removeAll(buttonBar.getChildren());
            buttonBar.getChildren().add((Node) FXMLLoader.load(HomeChefApplication.class.getResource("buttonBarInterf2.fxml")));
        } catch (IOException e) {
            buttonBar.getChildren().removeAll(buttonBar.getChildren());
        }
    }
    @FXML
    protected void goBack(){
        pageSwitch.backTo();
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
