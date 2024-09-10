package com.example.homechef.viewController.login;

import com.example.homechef.pageSwitch.Page;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginViewControllerInterf2 {

    private final Page pageSwitch;

    @FXML
    private Button loginButton;
    @FXML
    private TextField labUser;
    @FXML
    private PasswordField labPassword;
    @FXML
    private Button switchUiButton;
    @FXML
    private Button showPasswdButton;


    public LoginViewControllerInterf2(){
        pageSwitch =new Page();
        //clicked=false;
    }

    @FXML
    protected void switchToHomePage(ActionEvent event) {

        // TO BE IMPLEMENTED
        // - prende le credenziali
        // - Creazione bean utente
        // - Invocazione check sul controller utenza.
        // - aprire la pagina corretta
        pageSwitch.switchTo("search/interf2.fxml",event,"Search");
    }
    @FXML
    protected void switchToSignup(ActionEvent event) {
        pageSwitch.switchTo("signup/interf2.fxml",event,"Signup");
    }

    @FXML
    protected void switchToRecoverPswd(ActionEvent event) {
        pageSwitch.switchTo("recoverpassword/interf2.fxml",event,"RecoverPsw");
    }

    @FXML
    protected void switchToSignUpChef(ActionEvent event) {
        pageSwitch.switchTo("signupChef/interf2.fxml",event,"SignupChef");
    }
    @FXML
    protected void resize(ActionEvent event) {
        pageSwitch.setSize("login/interf2.fxml",event);
    }

}