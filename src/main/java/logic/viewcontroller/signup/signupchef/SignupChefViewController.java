package logic.viewcontroller.signup.signupchef;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import logic.appcontroller.SignupController;
import logic.beans.Chefbean;
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

        // Controllo valori

        Chefbean chBean = new Chefbean(super.namesign.getText(),super.surnamesign.getText(),super.email.getText(),super.pswd.getText(),this.citysign.getText(),this.restaurant.getText(),this.bestDish.getText());
        SignupController controller = new SignupController();
        controller.signup(chBean);
    }
}
