package logic.viewcontroller.search;

import logic.pageswitch.PageMenu;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class SearchViewControllerInterf1 {
    private PageMenu pageSwitch;
    @FXML
    private TextField chefName;
    @FXML
    private TextField eatName;

    public SearchViewControllerInterf1(){
        pageSwitch=new PageMenu();
    }

    @FXML
    protected void goToISC(ActionEvent event){
        pageSwitch.switchToISCUser(event);
    }
    @FXML
    protected void goToBook(ActionEvent event){
        pageSwitch.switchToBookList(event);
    }
    @FXML
    protected void goToHome(ActionEvent event){
        pageSwitch.switchToHome(event);
    }

    @FXML
    protected void search(ActionEvent event){
        pageSwitch.switchTo("resultsearch/interf1.fxml",event,"ResultSearch");
    }

    @FXML
    protected void goToSettings(ActionEvent event){
        pageSwitch.switchToSettings(event);
    }

}
