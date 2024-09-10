package logic.viewcontroller.book;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import logic.pageswitch.PageMenu;

public class BookViewControllerInterf1 {
    private PageMenu pageSwitch;

    public BookViewControllerInterf1(){
        pageSwitch = new PageMenu();
    }
    @FXML
    protected void backTo() {
        pageSwitch.backTo();
    }
    @FXML
    protected void goToSettings(ActionEvent event) {
        pageSwitch.switchToSettings(event);
    }
}
