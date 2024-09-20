package logic.viewcontroller.initialsearchandchat;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.TextField;
import logic.pageswitch.PageMenu;

public class InitialSearchAndChatChefViewControllerInterf1 {
    private PageMenu pageswitch;
    @FXML
    private Group group1;
    @FXML
    private Group group2;
    @FXML
    private Group group3;
    @FXML
    private Group group4;
    @FXML
    private Group extGroup1;
    @FXML
    private Group extGroup2;
    @FXML
    private Group extGroup3;
    @FXML
    private Group extGroup4;
    @FXML
    private TextField searchBar;

    public InitialSearchAndChatChefViewControllerInterf1() {
        pageswitch = new PageMenu();
    }

    @FXML
    protected void touchChatChef(ActionEvent event){
        pageswitch.switchTo("chatchef/interf1.fxml",event,"Chat");
    }

    @FXML
    protected void goToSettingsChef(ActionEvent event) {
        pageswitch.switchToSettingsChef(event);
    }
    @FXML
    protected void goToISCChef(ActionEvent event) {
        pageswitch.switchToISCChef(event);
    }
    @FXML
    protected  void goToBookListChef(ActionEvent event) {
        //metodo che va alle prenotazioni pendenti
        pageswitch.switchToBookListChef(event);
    }
    @FXML
    protected void outputValChat() {
        //controllore per caricare altre chat
    }
    @FXML
    protected void searchMessage(){
        //cerca del messaggio tra le chat
    }
    @FXML
    protected void goToHomeChef(ActionEvent event){
        pageswitch.switchToHomeChef(event);
    }
}
