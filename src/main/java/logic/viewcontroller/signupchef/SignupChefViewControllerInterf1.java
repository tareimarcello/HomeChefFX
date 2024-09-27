package logic.viewcontroller.signupchef;

import javafx.scene.control.TextField;
import logic.pageswitch.Page;
import javafx.fxml.FXML;
import logic.viewcontroller.signup.SignupViewController;

public class SignupChefViewControllerInterf1 extends SignupViewController {

    @FXML
    private TextField citysign;
    @FXML
    private TextField bestDish;
    @FXML
    private TextField restaurant;

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
