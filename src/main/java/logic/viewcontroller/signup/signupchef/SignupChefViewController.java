package logic.viewcontroller.signup.signupchef;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import logic.beans.Chefbean;
import logic.homechefutil.HomeChefUtil;
import logic.pageswitch.Page;
import logic.viewcontroller.signup.SignupViewController;

import java.util.ArrayList;
import java.util.List;

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
        List<String> paramSave = new ArrayList<String>() {};
        paramSave.add(namesign.getText().toUpperCase());
        paramSave.add(surnamesign.getText().toUpperCase());
        paramSave.add(email.getText());
        paramSave.add(citysign.getText().toUpperCase());
        paramSave.add(restaurant.getText().toUpperCase());
        paramSave.add(bestDish.getText().toUpperCase());
        // Controllo valori
        if(checkValid() && checkValidChef()) {
            paramSave = HomeChefUtil.setFormat(paramSave);
            Chefbean chBean = new Chefbean(paramSave.get(0), paramSave.get(1), paramSave.get(2), super.pswd.getText().toUpperCase(), paramSave.get(3), paramSave.get(4), paramSave.get(5));
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
