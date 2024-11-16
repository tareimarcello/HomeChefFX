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
        resetOpMsg();
        if(restaurant.getText().equals("")) {
            restaurant.setText("");
            setResOpMsg(false);
            errMsg.setText("Restaurant field is empty");
        }else{
            resetOpMsg();
            EditChefProfileBean updateRes = new EditChefProfileBean("", "",ViewSetter.getInstance().getSessionParam().getCurrentUserId(),restaurant.getText().toUpperCase(),"");
            restaurant.setText("");
            SettingsController controller = new SettingsController();
            try {
                controller.updateRes(updateRes);
                setResOpMsg(true);
                rightMsg.setText("Restaurant updated");
            } catch (ConnectionException e) {
                Exceptions.exceptionConnectionOccurred();
            }catch(EditProfException e){
                setResOpMsg(false);
                errMsg.setText(e.getMessage());
            }

        }
    }
    @FXML
    protected void updateCity(){
        resetOpMsg();
        if(city.getText().equals("")) {
            city.setText("");
            setResOpMsg(false);
            errMsg.setText("City field is empty");
        }else{
            resetOpMsg();
            EditChefProfileBean updateRes = new EditChefProfileBean("", "",ViewSetter.getInstance().getSessionParam().getCurrentUserId(),"",city.getText().toUpperCase());
            city.setText("");
            SettingsController controller = new SettingsController();
            try {
                controller.updateCity(updateRes);
                setResOpMsg(true);
                rightMsg.setText("City updated");
            } catch (ConnectionException e) {
                Exceptions.exceptionConnectionOccurred();
            }catch(EditProfException e){
                setResOpMsg(false);
                errMsg.setText(e.getMessage());
            }

        }
    }
}
