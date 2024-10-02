package logic.viewcontroller.signup;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import logic.appcontroller.SignupController;
import logic.beans.Customerbean;

public abstract class SignupViewController {


    protected final static SignupController controller = new SignupController();

    @FXML
    protected TextField namesign;
    @FXML
    protected TextField surnamesign;
    @FXML
    protected PasswordField pswd;
    @FXML
    protected TextField email;
    @FXML
    protected PasswordField confirmPswd;


    protected abstract void goToLogin();


    protected abstract void save();

}
