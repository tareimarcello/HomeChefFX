package logic.viewcontroller.signup;

import javafx.fxml.FXML;

import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import logic.appcontroller.SignupController;
import logic.beans.Userbean;
import logic.exceptions.ConnectionException;
import logic.exceptions.Exceptions;
import logic.exceptions.MailAlreadyUsed;



public abstract class SignupViewController {


    protected SignupController controller;

    @FXML
    protected TextField namesign;
    @FXML
    protected TextField surnamesign;
    @FXML
    protected PasswordField pswd;
    @FXML
    protected TextField email;
    @FXML
    protected PasswordField confirmpswd;
    @FXML
    protected Label rghtMsg;
    @FXML
    protected Label errMsg;

    protected abstract void goToLogin();


    protected abstract void save();

    public void initialize(){
        rghtMsg.setOpacity(0.0);
        errMsg.setOpacity(0.0);
    }

    protected void launchController(Userbean bean){
        try {
            controller.signup(bean);
            rghtMsg.setOpacity(1.0);
            rghtMsg.setText("Signup successful");
        } catch (ConnectionException e) {
            Exceptions.exceptionConnectionOccurred();
        } catch (MailAlreadyUsed e) {
            errMsg.setOpacity(1.0);
            errMsg.setText(e.getMessage());
        }
    }


}
