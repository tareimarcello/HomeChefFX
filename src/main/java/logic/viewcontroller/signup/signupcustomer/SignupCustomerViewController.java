package logic.viewcontroller.signup.signupcustomer;

import javafx.fxml.FXML;
import logic.beans.Customerbean;
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

        rghtMsg.setOpacity(0.0);
        errMsg.setOpacity(0.0);
        if(checkValid()){
            Customerbean cBean = new Customerbean(namesign.getText().toUpperCase(), surnamesign.getText().toUpperCase(), email.getText(), pswd.getText());
            launchController(cBean);
        }
    }

}
