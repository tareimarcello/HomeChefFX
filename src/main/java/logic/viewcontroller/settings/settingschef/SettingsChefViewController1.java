package logic.viewcontroller.settings.settingschef;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import logic.appcontroller.SettingsController;
import logic.beans.EditChefProfileBean;
import logic.exceptions.ConnectionException;
import logic.exceptions.Exceptions;
import logic.exceptions.SameResException;
import logic.patterns.ViewSetter;
import logic.viewcontroller.settings.settingscustomer.SettingsViewControllerInterf1;

public class SettingsChefViewController1 extends SettingsViewControllerInterf1 {

    @FXML
    protected TextField restaurant;
    @FXML
    protected TextField city;

    @FXML
    protected void goEditRestaurant(){
        errMsg.setOpacity(0.0);
        rightMsg.setOpacity(0.0);
        if(restaurant.getText().equals("")) {
            resetMailAndPassword();
            restaurant.setText("");
            rightMsg.setOpacity(0.0);
            errMsg.setOpacity(1.0);
            errMsg.setText("Restaurant is empty");
        }else{
            errMsg.setOpacity(0.0);
            rightMsg.setOpacity(0.0);
            EditChefProfileBean updateRes = new EditChefProfileBean("", "",ViewSetter.getInstance().getSessionParam().getCurrentUserId(),restaurant.getText().toUpperCase());
            resetMailAndPassword();
            restaurant.setText("");
            SettingsController controller = new SettingsController();
            try {
                controller.updateRes(updateRes);
                errMsg.setOpacity(0.0);
                rightMsg.setOpacity(1.0);
                rightMsg.setText("Restaurant updated");
            } catch (ConnectionException e) {
                Exceptions.exceptionConnectionOccurred();
            }catch(SameResException e){
                rightMsg.setOpacity(0.0);
                errMsg.setOpacity(1.0);
                errMsg.setText(e.getMessage());
            }

        }
    }
    @FXML
    protected void updateCity(){
        //to be implemented
    }
}
