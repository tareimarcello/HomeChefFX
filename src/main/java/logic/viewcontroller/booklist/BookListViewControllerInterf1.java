package logic.viewcontroller.booklist;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import logic.pageswitch.PageMenu;


public class BookListViewControllerInterf1 extends BookListViewController{
    private PageMenu pageswitch;

    public BookListViewControllerInterf1(){
        pageswitch = new PageMenu();
    }

    @FXML
    protected void goToHome(ActionEvent event) {
        pageswitch.switchToHome(event);
    }
    @FXML
    protected void goToBookList(ActionEvent event) {
        pageswitch.switchToBookList(event);
    }
    @FXML
    protected void goToISC(ActionEvent event) {
        pageswitch.switchToISCUser(event);
    }
    @FXML
    protected void goToSettings(ActionEvent event) {
        pageswitch.switchToSettings(event);
    }
    @FXML
    protected void goToHomeChef(ActionEvent event) {
        pageswitch.switchToHomeChef(event);
    }
    @FXML
    protected void goToBookListChef(ActionEvent event) {
        pageswitch.switchToBookListChef(event);
    }
    @FXML
    protected void goToISCChef(ActionEvent event) {
        pageswitch.switchToISCChef(event);
    }
    @FXML
    protected void goToSettingsChef(ActionEvent event) {
        pageswitch.switchToSettingsChef(event);
    }

}
