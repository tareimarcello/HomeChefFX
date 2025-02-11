package logic.viewcontroller.settings;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import logic.appcontroller.EditProfileController;
import logic.beans.EditChefProfileBean;
import logic.beans.EditProfileBean;
import logic.exceptions.*;
import logic.pageswitch.PageMenu;
import logic.patterns.Setter;

public abstract class SettingViewController {
    protected EditProfileController controller;
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

        EditProfileBean bean = new EditProfileBean("","", Setter.getSessionParam().getCurrentUserId());
        if(!bean.setPswd(pswd.getText())){
            setResOpMsg(false);
            errMsg.setText("Password is empty");
            pswd.setText("");
            confirmpswd.setText("");
        }else {
            try {
                controller.updatePswd(bean);
                setResOpMsg(true);
                rightMsg.setText("Password updated");
            } catch (ConnectionException e) {
                Exceptions.exceptionConnectionOccurred();
            } catch (EditProfException e) {
                setResOpMsg(false);
                errMsg.setText(e.getMessage());
            }
        }
    }
    @FXML
    protected abstract void signOut(ActionEvent event);
    @FXML
    protected void setMail() {
        EditProfileBean updateEmail = new EditProfileBean("", "", Setter.getSessionParam().getCurrentUserId());
        if (!updateEmail.setEmail(email.getText())) {
            email.setText("");
            setResOpMsg(false);
            errMsg.setText("Email is empty or Invalid Format");
        } else {
            resetOpMsg();
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
        EditChefProfileBean updateRes = new EditChefProfileBean("", "", Setter.getSessionParam().getCurrentUserId(),"","");
        if(!updateRes.setRes(restaurant.getText().toUpperCase())){
            restaurant.setText("");
            setResOpMsg(false);
            errMsg.setText("Restaurant field is empty");
        }else{
            resetOpMsg();
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
        EditChefProfileBean updateCity = new EditChefProfileBean("", "", Setter.getSessionParam().getCurrentUserId(),"","");
        if(!updateCity.setCity(city.getText().toUpperCase())) {
            city.setText("");
            setResOpMsg(false);
            errMsg.setText("City field is empty");
        }else{
            resetOpMsg();
            city.setText("");
            try {
                controller.updateCity(updateCity);
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
