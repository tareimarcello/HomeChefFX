package logic.viewcontroller.resultsearch;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import logic.pageswitch.PageMenu;

public class ResultSearchViewControllerInterf1 {
    private PageMenu pageSwitch;
    @FXML
    private Text name;
    @FXML
    private Text res;
    @FXML
    private Text spec;
    @FXML
    private Text name5;
    @FXML
    private Text res5;
    @FXML
    private Text spec5;
    @FXML
    private Text name6;
    @FXML
    private Text res6;
    @FXML
    private Text spec6;
    @FXML
    private Text name7;
    @FXML
    private Text res7;
    @FXML
    private Text spec7;


    public ResultSearchViewControllerInterf1(){
        pageSwitch = new PageMenu();
    }
    @FXML
    protected void goToBook(){

    }
    @FXML
    protected void goToHome(ActionEvent event){
        pageSwitch.switchToHome(event);
    }
    @FXML
    protected void outputVal(ActionEvent event){
    }
    @FXML
    protected void visit(ActionEvent event){
        pageSwitch.switchToHomeChef(event);
    }
    @FXML
    protected void touchChat(){

    }
    @FXML
    protected void goToSettings(ActionEvent event){
        pageSwitch.switchToSettings(event);
    }
    @FXML
    protected void goToISC(){

    }
}
