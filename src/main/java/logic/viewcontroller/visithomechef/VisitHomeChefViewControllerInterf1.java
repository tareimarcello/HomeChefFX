package logic.viewcontroller.visithomechef;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import logic.pageswitch.PageMenu;

public class VisitHomeChefViewControllerInterf1 {
    private PageMenu pageSwitch;
    @FXML
    private TextField chefName;
    @FXML
    private TextField bestDish;
    @FXML
    private TextField res;

    public VisitHomeChefViewControllerInterf1() {
        pageSwitch = new PageMenu();
    }

    public void initialize(){

    }

    @FXML
    protected void backTo(){
        pageSwitch.backTo();
    }

    @FXML
    protected void goToSettings(ActionEvent event){
        pageSwitch.switchToSettings(event);
    }

    @FXML
    protected void goToChefChat(){

    }

    @FXML
    protected void gotoRatings(){

    }

    @FXML
    protected void goToBookChef(ActionEvent event){
        pageSwitch.switchTo("clientbook/interf1.fxml",event,"Book Chef");
    }
    @FXML
    protected void goToBook(){

    }
    @FXML
    protected void goToISC(){

    }
    @FXML
    protected void goToHome(ActionEvent event){
        pageSwitch.switchToHome(event);
    }
}
