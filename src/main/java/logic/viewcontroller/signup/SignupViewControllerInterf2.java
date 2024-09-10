package logic.viewcontroller.signup;

import logic.pageswitch.Page;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SignupViewControllerInterf2 {

    @FXML
    private TextField email;

    @FXML
    private PasswordField confirmPswd;

    @FXML
    private PasswordField pswd;

    @FXML
    private Label desCheck;

    @FXML
    private Label emailCheck;

    @FXML
    private Label goalCheck;



    @FXML
    protected void goToLogin(){

        Page pageSwitch=new Page();
        pageSwitch.backTo();

    }


    @FXML
    protected void save(){

        // Controllo valori
        // In caso di errore set opacity label
        // If ok salvataggio bean

    }
}
