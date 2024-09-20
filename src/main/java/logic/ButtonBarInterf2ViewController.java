package logic;

import logic.pageswitch.PageMenu;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class ButtonBarInterf2ViewController {
    private PageMenu pageSwitch;

    public ButtonBarInterf2ViewController(){
        pageSwitch=new PageMenu();
    }

    @FXML
    protected void goToIsc(ActionEvent actionEvent) {
        pageSwitch.switchTo("chatuser/interf2.fxml",actionEvent,"Search and Chat");
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
    protected void goToBookList(ActionEvent actionEvent) {
        pageSwitch.switchToBookList(actionEvent);
    }
    @FXML
    protected void goToIscChef(ActionEvent actionEvent) {
        pageSwitch.switchTo("chatchef/interf2.fxml",actionEvent,"Search and Chat");
    }
    @FXML
    protected void goToSettingsChef(ActionEvent actionEvent) {
        pageSwitch.switchToSettingsChef(actionEvent);
    }
    @FXML
    protected void goToHomeChef(ActionEvent actionEvent) {
        pageSwitch.switchToHomeChef(actionEvent);
    }
    @FXML
    protected void goToBookListChef(ActionEvent actionEvent) {
        pageSwitch.switchToBookList(actionEvent);
    }
}
