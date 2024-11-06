package logic.viewcontroller.signup.signupcustomer;

import javafx.fxml.FXML;
import logic.beans.Customerbean;
import logic.exceptions.Exceptions;
import logic.pageswitch.Page;
import logic.viewcontroller.signup.SignupViewController;

public class SignupCustomerViewController extends SignupViewController {
    @FXML
    @Override
    protected void goToLogin(){

        Page pageSwitch=new Page();
        pageSwitch.backTo();

    }
    @Override
    @FXML
    protected void save() {

        // Controllo valori

        // In caso di errore set opacity label

        Customerbean cBean = new Customerbean(namesign.getText().toUpperCase(),surnamesign.getText().toUpperCase(),email.getText(), pswd.getText());
        try {
            controller.signup(cBean);
        } catch (Exception e) {
            Exceptions.exceptionConnectionOccurred();
        }
    }

}
