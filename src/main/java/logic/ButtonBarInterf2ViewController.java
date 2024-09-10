package logic;

import logic.pageSwitch.PageMenu;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ButtonBarInterf2ViewController {
    PageMenu pageSwitch;

    public ButtonBarInterf2ViewController(){
        pageSwitch=new PageMenu();
    }

    @FXML
    protected void goToChat(ActionEvent actionEvent) {
        pageSwitch.switchToChat(actionEvent);
    }
    @FXML
    protected void goToSettings(ActionEvent actionEvent) {
        pageSwitch.switchToSettings(actionEvent);
    }
    @FXML
    protected void goToHome(ActionEvent actionEvent) {
        pageSwitch.switchToHome(actionEvent);
    }
    @FXML
    protected void goToBooking(ActionEvent actionEvent) {
        pageSwitch.switchToBook(actionEvent);
    }
}
