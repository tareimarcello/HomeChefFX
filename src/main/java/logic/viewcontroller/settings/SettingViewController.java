package logic.viewcontroller.settings;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import logic.appcontroller.SettingsController;
import logic.beans.UpdatePswdBean;
import logic.exceptions.ConnectionException;
import logic.exceptions.Exceptions;
import logic.exceptions.SamePasswordException;
import logic.patterns.ViewSetter;

import java.util.Objects;

public abstract class SettingViewController {
    @FXML
    protected TextField email;
    @FXML
    protected TextField pswd;
    @FXML
    protected TextField confirmpswd;
    @FXML
    protected Text rightMsg;
    @FXML
    protected Text errMsg;
    @FXML
    protected abstract void goBack();

    public void initialize(){
        errMsg.setOpacity(0.0);
        rightMsg.setOpacity(0.0);
    }
    @FXML
    protected void setPswd(){
        if(pswd.getText().equals("")){
            errMsg.setOpacity(1.0);
            errMsg.setText("Password is empty");
        }else if (confirmpswd.getText().equals("")){
            errMsg.setOpacity(1.0);
            errMsg.setText("ConfirmPassword is empty");
        }else if(!Objects.equals(pswd.getText(), confirmpswd.getText())){
            errMsg.setOpacity(1.0);
            errMsg.setText("Passwords don't match");
        }else{
            UpdatePswdBean bean = new UpdatePswdBean(pswd.getText(), ViewSetter.getInstance().getSessionParam().getCurrentUserId());
            SettingsController controller = new SettingsController();
            try {
                controller.updatePswd(bean);
                rightMsg.setOpacity(1.0);
                rightMsg.setText("Password updated");
            } catch (ConnectionException e) {
                Exceptions.exceptionConnectionOccurred();
            }catch(SamePasswordException e){
                errMsg.setOpacity(1.0);
                errMsg.setText(e.getMessage());
            }
        }

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
