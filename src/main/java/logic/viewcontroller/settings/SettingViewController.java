package logic.viewcontroller.settings;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import logic.appcontroller.SettingsController;
import logic.beans.EditChefProfileBean;
import logic.beans.EditProfileBean;
import logic.exceptions.*;
import logic.homechefutil.HomeChefUtil;
import logic.pageswitch.PageMenu;
import logic.patterns.ViewSetter;

import java.util.Objects;

public abstract class SettingViewController {
    protected static final SettingsController controller = new SettingsController();
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
    protected TextField restaurant;
    @FXML
    protected TextField city;
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
            EditProfileBean bean = new EditProfileBean("",pswd.getText(), ViewSetter.getSessionParam().getCurrentUserId());
            pswd.setText("");
            confirmpswd.setText("");
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
            EditProfileBean updateEmail = new EditProfileBean(email.getText(), "", ViewSetter.getSessionParam().getCurrentUserId());
            email.setText("");
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
    protected void resetOpMsg(){
        errMsg.setOpacity(0.0);
        rightMsg.setOpacity(0.0);
    }
    protected void setResOpMsg(boolean righOrErr){
        if(righOrErr){
            rightMsg.setOpacity(1.0);
            errMsg.setOpacity(0.0);
        }else{
            rightMsg.setOpacity(0.0);
            errMsg.setOpacity(1.0);
        }
    }


    @FXML
    protected void goEditRestaurant(){
        resetOpMsg();
        if(restaurant.getText().equals("")) {
            restaurant.setText("");
            setResOpMsg(false);
            errMsg.setText("Restaurant field is empty");
        }else{
            resetOpMsg();
            EditChefProfileBean updateRes = new EditChefProfileBean("", "",ViewSetter.getSessionParam().getCurrentUserId(),restaurant.getText().toUpperCase(),"");
            restaurant.setText("");
            try {
                controller.updateRes(updateRes);
                setResOpMsg(true);
                rightMsg.setText("Restaurant updated");
            } catch (ConnectionException e) {
                Exceptions.exceptionConnectionOccurred();
            }catch(EditProfException e){
                setResOpMsg(false);
                errMsg.setText(e.getMessage());
            }

        }
    }
    @FXML
    protected void updateCity(){
        resetOpMsg();
        if(city.getText().equals("")) {
            city.setText("");
            setResOpMsg(false);
            errMsg.setText("City field is empty");
        }else{
            resetOpMsg();
            String cityEdit=city.getText().toUpperCase();
            while(cityEdit.endsWith(" ")){
                cityEdit =cityEdit.substring(0,cityEdit.length()-1);
            }
            EditChefProfileBean updateRes = new EditChefProfileBean("", "",ViewSetter.getSessionParam().getCurrentUserId(),"",cityEdit);
            city.setText("");
            try {
                controller.updateCity(updateRes);
                setResOpMsg(true);
                rightMsg.setText("City updated");
            } catch (ConnectionException e) {
                Exceptions.exceptionConnectionOccurred();
            }catch(EditProfException e){
                setResOpMsg(false);
                errMsg.setText(e.getMessage());
            }

        }
    }
}
