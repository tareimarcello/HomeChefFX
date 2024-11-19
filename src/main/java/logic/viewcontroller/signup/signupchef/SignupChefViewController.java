package logic.viewcontroller.signup.signupchef;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import logic.appcontroller.SignupController;
import logic.beans.Chefbean;
import logic.exceptions.ConnectionException;
import logic.exceptions.Exceptions;
import logic.exceptions.MailAlreadyUsed;
import logic.pageswitch.Page;
import logic.viewcontroller.signup.SignupViewController;

public class SignupChefViewController extends SignupViewController {

    @FXML
    private TextField citysign;
    @FXML
    private TextField bestDish;
    @FXML
    private TextField restaurant;


    @FXML
    @Override
    protected void goToLogin() {
        Page pageSwitch=new Page();
        pageSwitch.backTo();
    }

    @FXML
    @Override
    protected void save(){
        errMsg.setOpacity(0.0);
        rghtMsg.setOpacity(0.0);
        // Controllo valori
        if(checkValid() && checkValidChef()) {
                Chefbean chBean = new Chefbean(super.namesign.getText().toUpperCase(), super.surnamesign.getText().toUpperCase(), super.email.getText(), super.pswd.getText(), this.citysign.getText().toUpperCase(), this.restaurant.getText().toUpperCase(), this.bestDish.getText().toUpperCase());
                launchController(chBean);
        }
    }

    private boolean checkValidChef(){
        if((restaurant.getText().equals(""))){
            errMsg.setOpacity(1.0);
            errMsg.setText("Restaurant missing");
            return false;
        }else if (citysign.getText().equals("")){
            errMsg.setOpacity(1.0);
            errMsg.setText("City missing");
            return false;
        }else if (bestDish.getText().equals("")){
            errMsg.setOpacity(1.0);
            errMsg.setText("Best Dish missing");
            return false;
        }
        return true;
    }
}
