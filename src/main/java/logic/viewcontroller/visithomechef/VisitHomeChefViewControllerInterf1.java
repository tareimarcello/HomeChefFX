package logic.viewcontroller.visithomechef;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import logic.beans.HomeChefBean;
import logic.pageswitch.PageMenu;
import logic.patterns.ViewSetter;

public class VisitHomeChefViewControllerInterf1 {
    private PageMenu pageSwitch;
    @FXML
    private TextField chefName;
    @FXML
    private TextField bestDish;
    @FXML
    private TextField res;
    @FXML
    private TextField city;

    public VisitHomeChefViewControllerInterf1() {
        pageSwitch = new PageMenu();
    }

    public void initialize(){


        HomeChefBean hcbean = ViewSetter.getInstance().getHcvisitbean();

        if (hcbean!=null) {

            this.chefName.setText(hcbean.getName());
            this.bestDish.setText(hcbean.getDish());
            this.res.setText(hcbean.getRes());
            this.city.setText(hcbean.getCity());

        }
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
    protected void goToChefChat(ActionEvent event){

        pageSwitch.switchTo("chatuser/interf1.fxml",event,"Chef Chat");
    }

    @FXML
    protected void goToBookChef(ActionEvent event){
        pageSwitch.switchTo("clientbook/interf1.fxml",event,"Book Chef");
    }
    @FXML
    protected void goToBook(ActionEvent event){
        pageSwitch.switchToBookList(event);
    }
    @FXML
    protected void goToISC(ActionEvent event){
        pageSwitch.switchToISCUser(event);
    }
    @FXML
    protected void goToHome(ActionEvent event){
        pageSwitch.switchToHome(event);
    }
}
