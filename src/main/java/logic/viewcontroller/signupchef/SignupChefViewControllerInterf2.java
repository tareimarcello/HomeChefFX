package logic.viewcontroller.signupchef;

import javafx.scene.control.TextField;
import logic.pageswitch.Page;
import javafx.fxml.FXML;

public class SignupChefViewControllerInterf2 {

    @FXML
    private TextField namesign;
    @FXML
    private TextField surnamesign;
    @FXML
    private TextField citysign;

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
