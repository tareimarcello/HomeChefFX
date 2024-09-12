package logic.viewcontroller.resultsearch;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import logic.pageswitch.PageMenu;

public class ResultSearchViewControllerInterf2 {
    private PageMenu pageSwitch;
    @FXML
    private Text name;
    @FXML
    private Text res;
    @FXML
    private Text spec;
    @FXML
    private Text name2;
    @FXML
    private Text res2;
    @FXML
    private Text spec2;
    @FXML
    private Text name1;
    @FXML
    private Text res1;
    @FXML
    private Text spec1;
    @FXML
    private Text name3;
    @FXML
    private Text res3;
    @FXML
    private Text spec3;
    @FXML
    private Text name4;
    @FXML
    private Text res4;
    @FXML
    private Text spec4;
    @FXML
    private Text name5;
    @FXML
    private Text res5;
    @FXML
    private Text spec5;


    public ResultSearchViewControllerInterf2(){
        pageSwitch = new PageMenu();
    }
    @FXML
    protected void outputVal(){

    }
    @FXML
    protected void visit(ActionEvent event){
        pageSwitch.switchToHomeChef(event);
    }
    @FXML
    protected void touchChat(){

    }
}
