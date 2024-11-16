package logic.viewcontroller.settings;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import logic.appcontroller.SettingsController;
import logic.beans.EditProfileBean;
import logic.exceptions.*;
import logic.homechefutil.HomeChefUtil;
import logic.pageswitch.PageMenu;
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
    protected PageMenu pageSwitch;
    @FXML
    protected abstract void goBack();

    @FXML
    protected void setPswd(){
        errMsg.setOpacity(0.0);
        rightMsg.setOpacity(0.0);
        if(pswd.getText().equals("")){
            pswd.setText("");
            confirmpswd.setText("");
            rightMsg.setOpacity(0.0);
            errMsg.setOpacity(1.0);
            errMsg.setText("Password is empty");
        }else if (confirmpswd.getText().equals("")){
            pswd.setText("");
            confirmpswd.setText("");
            rightMsg.setOpacity(0.0);
            errMsg.setOpacity(1.0);
            errMsg.setText("ConfirmPassword is empty");
        }else if(!Objects.equals(pswd.getText(), confirmpswd.getText())){
            pswd.setText("");
            confirmpswd.setText("");
            rightMsg.setOpacity(0.0);
            errMsg.setOpacity(1.0);
            errMsg.setText("Passwords don't match");
        }else{
            EditProfileBean bean = new EditProfileBean("",pswd.getText(), ViewSetter.getInstance().getSessionParam().getCurrentUserId());
            pswd.setText("");
            confirmpswd.setText("");
            SettingsController controller = new SettingsController();
            try {
                controller.updatePswd(bean);
                errMsg.setOpacity(0.0);
                rightMsg.setOpacity(1.0);
                rightMsg.setText("Password updated");
            } catch (ConnectionException e) {
                Exceptions.exceptionConnectionOccurred();
            }catch(EditProfException e){
                rightMsg.setOpacity(0.0);
                errMsg.setOpacity(1.0);
                errMsg.setText(e.getMessage());
            }
        }

    }
    @FXML
    protected abstract void signOut(ActionEvent event);
    @FXML
    protected void setMail() {
        if (email.getText().equals("")) {
            email.setText("");
            rightMsg.setOpacity(0.0);
            errMsg.setOpacity(1.0);
            errMsg.setText("Email is empty");
        } else if (!HomeChefUtil.isValidEmail(email.getText())) {
            email.setText("");
            rightMsg.setOpacity(0.0);
            errMsg.setOpacity(1.0);
            errMsg.setText("Email format is not valid");
        } else {
            errMsg.setOpacity(0.0);
            rightMsg.setOpacity(0.0);
            EditProfileBean updateEmail = new EditProfileBean(email.getText(), "", ViewSetter.getInstance().getSessionParam().getCurrentUserId());
            email.setText("");
            SettingsController controller = new SettingsController();
            try {
                controller.updateMail(updateEmail);
                errMsg.setOpacity(0.0);
                rightMsg.setOpacity(1.0);
                rightMsg.setText("Email updated");
            } catch (ConnectionException e) {
                Exceptions.exceptionConnectionOccurred();
            } catch (EditProfException e) {
                rightMsg.setOpacity(0.0);
                errMsg.setOpacity(1.0);
                errMsg.setText(e.getMessage());
            }

        }
    }

}
