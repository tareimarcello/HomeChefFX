package logic.viewcontroller.signup.signupcustomer;

import javafx.fxml.FXML;
import logic.appcontroller.SignupController;
import logic.beans.Customerbean;
import logic.pageswitch.Page;
import logic.viewcontroller.signup.SignupViewController;

public class SignupCustomerViewController extends SignupViewController {

    public SignupCustomerViewController() {
        controller = new SignupController();
    }

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
        Customerbean cBean = new Customerbean(namesign.getText().toUpperCase(), surnamesign.getText().toUpperCase(), email.getText(), pswd.getText());
        if(cBean.checkValid(namesign.getText().toUpperCase(), surnamesign.getText().toUpperCase(), email.getText(), pswd.getText())){
            launchController(cBean);
        }else{
            errMsg.setOpacity(1.0);
            errMsg.setText("Missing date");
        }
    }

}
