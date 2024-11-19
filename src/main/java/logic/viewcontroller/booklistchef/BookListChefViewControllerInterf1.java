package logic.viewcontroller.booklistchef;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import logic.viewcontroller.booklist.BookListViewController;

public class BookListChefViewControllerInterf1 extends BookListViewController {
    public void initialize(){

    }
    @FXML
    protected void goToHomeChef(ActionEvent event) {
        pageSwitch.switchToHomeChef(event);
    }
    @FXML
    protected void goToBookListChef(ActionEvent event) {
        pageSwitch.switchToBookListChef(event);
    }
    @FXML
    protected void goToISCChef(ActionEvent event) {
        pageSwitch.switchToISCChef(event);
    }
    @FXML
    protected void goToSettingsChef(ActionEvent event) {
        pageSwitch.switchToSettingsChef(event);
    }
}
