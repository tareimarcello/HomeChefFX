package logic;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import logic.pageswitch.PageMenu;

public class ButtonBarChefViewControllerInterf2 {
    private PageMenu pageSwitch;

    public ButtonBarChefViewControllerInterf2(){
        pageSwitch=new PageMenu();
    }

    @FXML
    protected void goToIsc(ActionEvent actionEvent) {
        pageSwitch.switchTo("chatuser/interf2.fxml",actionEvent,"Search and Chat");
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
