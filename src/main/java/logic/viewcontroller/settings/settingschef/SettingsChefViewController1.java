package logic.viewcontroller.settings.settingschef;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import logic.appcontroller.SettingsController;
import logic.beans.EditChefProfileBean;
import logic.exceptions.ConnectionException;
import logic.exceptions.EditProfException;
import logic.exceptions.Exceptions;
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
            restaurant.setText("");
            rightMsg.setOpacity(0.0);
            errMsg.setOpacity(1.0);
            errMsg.setText("Restaurant field is empty");
        }else{
            errMsg.setOpacity(0.0);
            rightMsg.setOpacity(0.0);
            EditChefProfileBean updateRes = new EditChefProfileBean("", "",ViewSetter.getInstance().getSessionParam().getCurrentUserId(),restaurant.getText().toUpperCase(),"");
            restaurant.setText("");
            SettingsController controller = new SettingsController();
            try {
                controller.updateRes(updateRes);
                errMsg.setOpacity(0.0);
                rightMsg.setOpacity(1.0);
                rightMsg.setText("Restaurant updated");
            } catch (ConnectionException e) {
                Exceptions.exceptionConnectionOccurred();
            }catch(EditProfException e){
                rightMsg.setOpacity(0.0);
                errMsg.setOpacity(1.0);
                errMsg.setText(e.getMessage());
            }

        }
    }
    @FXML
    protected void updateCity(){
        errMsg.setOpacity(0.0);
        rightMsg.setOpacity(0.0);
        if(city.getText().equals("")) {
            city.setText("");
            rightMsg.setOpacity(0.0);
            errMsg.setOpacity(1.0);
            errMsg.setText("City field is empty");
        }else{
            errMsg.setOpacity(0.0);
            rightMsg.setOpacity(0.0);
            EditChefProfileBean updateRes = new EditChefProfileBean("", "",ViewSetter.getInstance().getSessionParam().getCurrentUserId(),"",city.getText().toUpperCase());
            city.setText("");
            SettingsController controller = new SettingsController();
            try {
                controller.updateCity(updateRes);
                errMsg.setOpacity(0.0);
                rightMsg.setOpacity(1.0);
                rightMsg.setText("City updated");
            } catch (ConnectionException e) {
                Exceptions.exceptionConnectionOccurred();
            }catch(EditProfException e){
                rightMsg.setOpacity(0.0);
                errMsg.setOpacity(1.0);
                errMsg.setText(e.getMessage());
            }

        }
    }
}
