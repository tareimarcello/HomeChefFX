package logic.viewcontroller.homepagechef;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import logic.appcontroller.ISCController;
import logic.exceptions.ConnectionException;
import logic.exceptions.Exceptions;
import logic.patterns.ViewSetter;
import logic.beans.HomeChefBean;
import logic.pageswitch.PageMenu;

public class HomePageChefViewControllerInterf1 extends HomePageChefViewController{

    public HomePageChefViewControllerInterf1() {
        pageswitch = new PageMenu();
    }

    public void initialize() {
        setFields();

    }

    @FXML
    protected void goToSettings(ActionEvent event) {
        pageswitch.switchToSettingsChef(event);
    }
    @FXML
    protected void goToHome(ActionEvent event) {
        pageswitch.switchToHomeChef(event);
    }
    @FXML
    protected void goToISC(ActionEvent event) {
        pageswitch.switchToISCChef(event);
    }
    @FXML
    protected void goToListBookChef(ActionEvent event) {
        pageswitch.switchToBookListChef(event);
    }
}
