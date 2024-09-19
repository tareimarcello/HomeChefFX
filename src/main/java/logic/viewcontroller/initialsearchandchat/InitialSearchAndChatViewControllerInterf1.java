package logic.viewcontroller.initialsearchandchat;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import logic.pageswitch.PageMenu;

public class InitialSearchAndChatViewControllerInterf1 {
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

    public InitialSearchAndChatViewControllerInterf1() {
        pageswitch = new PageMenu();
    }
    @FXML
    protected void visit(ActionEvent event) {
        //parte di controllo
        pageswitch.switchTo("visithomepagechef/interf1.fxml",event,"Visit");
    }
    @FXML
    protected void touchChat(ActionEvent event){
        pageswitch.switchTo("chatuser/interf1.fxml",event,"Chat");
    }
    @FXML
    protected void goToSettings(ActionEvent event) {
        pageswitch.switchToSettings(event);
    }
    @FXML
    protected void goToISC(ActionEvent event) {
        pageswitch.switchToISCUser(event);
    }
    @FXML
    protected void goToHome(ActionEvent event) {
        pageswitch.switchToHome(event);
    }
    @FXML
    protected void searchMessage(){
        //controllore per cercare messaggio tra le chat
    }
    @FXML
    protected void outputValChat(){
        //controllore per caricare altre chat
    }
    @FXML
    protected  void goToBook(ActionEvent event) {
        //metodo che va alle prenotazioni pendenti
        pageswitch.switchToBookList(event);
    }
}
