package logic.viewcontroller.settings;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public abstract class SettingViewController {
    @FXML
    protected TextField email;
    @FXML
    protected TextField pswd;
    @FXML
    protected TextField confirmpswd;
    @FXML
    protected abstract void goBack();
    @FXML
    protected void setPswd(){
        //to be implemented
    }
    @FXML
    protected abstract void signOut(ActionEvent event);
    @FXML
    protected void setMail(){
        //to be implemented
    }
    @FXML
    protected void setFeed(){
        //to be implemented
    }
}
