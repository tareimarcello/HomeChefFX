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
        resetOpMsg();
        if(pswd.getText().equals("")){
            pswd.setText("");
            confirmpswd.setText("");
            setResOpMsg(false);
            errMsg.setText("Password is empty");
        }else if (confirmpswd.getText().equals("")){
            pswd.setText("");
            confirmpswd.setText("");
            setResOpMsg(false);
            errMsg.setText("ConfirmPassword is empty");
        }else if(!Objects.equals(pswd.getText(), confirmpswd.getText())){
            pswd.setText("");
            confirmpswd.setText("");
            setResOpMsg(false);
            errMsg.setText("Passwords don't match");
        }else{
            EditProfileBean bean = new EditProfileBean("",pswd.getText(), ViewSetter.getInstance().getSessionParam().getCurrentUserId());
            pswd.setText("");
            confirmpswd.setText("");
            SettingsController controller = new SettingsController();
            try {
                controller.updatePswd(bean);
                setResOpMsg(true);
                rightMsg.setText("Password updated");
            } catch (ConnectionException e) {
                Exceptions.exceptionConnectionOccurred();
            }catch(EditProfException e){
                setResOpMsg(false);
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
            setResOpMsg(false);
            errMsg.setText("Email is empty");
        } else if (!HomeChefUtil.isValidEmail(email.getText())) {
            email.setText("");
            setResOpMsg(false);
            errMsg.setText("Email format is not valid");
        } else {
            resetOpMsg();
            EditProfileBean updateEmail = new EditProfileBean(email.getText(), "", ViewSetter.getInstance().getSessionParam().getCurrentUserId());
            email.setText("");
            SettingsController controller = new SettingsController();
            try {
                controller.updateMail(updateEmail);
                setResOpMsg(true);
                rightMsg.setText("Email updated");
            } catch (ConnectionException e) {
                Exceptions.exceptionConnectionOccurred();
            } catch (EditProfException e) {
                setResOpMsg(false);
                errMsg.setText(e.getMessage());
            }

        }
    }
    private void resetOpMsg(){
        errMsg.setOpacity(0.0);
        rightMsg.setOpacity(0.0);
    }
    private void setResOpMsg(boolean righOrErr){
        if(righOrErr){
            rightMsg.setOpacity(1.0);
            errMsg.setOpacity(0.0);
        }else{
            rightMsg.setOpacity(0.0);
            errMsg.setOpacity(1.0);
        }
    }
}
