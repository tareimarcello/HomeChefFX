package logic.viewcontroller.signup.signupcustomer;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import logic.beans.Customerbean;
import logic.exceptions.ConnectionException;
import logic.exceptions.Exceptions;
import logic.exceptions.MailAlreadyUsed;
import logic.homechefutil.HomeChefUtil;
import logic.pageswitch.Page;
import logic.viewcontroller.signup.SignupViewController;

public class SignupCustomerViewController extends SignupViewController {
    @FXML
    protected Label rghtMsg;
    @FXML
    protected Label errMsg;
    public void initialize(){
        rghtMsg.setOpacity(0.0);
        errMsg.setOpacity(0.0);
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

        // Controllo valori

        // In caso di errore set opacity label
        rghtMsg.setOpacity(0.0);
        errMsg.setOpacity(0.0);
        if(namesign.getText().equals("") || surnamesign.getText().equals("")){
            errMsg.setOpacity(1.0);
            errMsg.setText("Name or surname missing");
        }else if(!HomeChefUtil.isValidEmail(email.getText())) {
            errMsg.setText("Please enter a valid email address");
            errMsg.setOpacity(1.0);
        }else if(pswd.getText().isEmpty() || confirmpswd.getText().isEmpty() || !pswd.getText().equals(confirmpswd.getText())){
            errMsg.setOpacity(1.0);
            errMsg.setText("Password must match");
        }else {
            Customerbean cBean = new Customerbean(namesign.getText().toUpperCase(), surnamesign.getText().toUpperCase(), email.getText(), pswd.getText());
            try {
                controller.signup(cBean);
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

}
