package logic.viewcontroller.homepagechef;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import logic.pageswitch.PageMenu;

public class HomePageChefViewControllerInterf1 {
    private PageMenu pageswitch;
    @FXML
    private TextField name;
    @FXML
    private TextField dish;
    @FXML
    private TextField res;

    public HomePageChefViewControllerInterf1() {
        pageswitch = new PageMenu();
    }

    public void initialize() {
        //scrivi nei text field nome res e piatto dello chef
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
