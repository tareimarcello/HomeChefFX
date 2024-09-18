package logic.viewcontroller.initialsearchandchat;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import logic.HomeChefApplication;
import logic.pageswitch.PageMenu;

import java.io.IOException;

public class InitialSearchAndChatViewControllerInterf2 {
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
    AnchorPane anchorChat;
    @FXML
    TextField searchBar;
    @FXML
    AnchorPane listUtenti;
    //vedere bene come fa apparire la lista degli utenti, messo un solo gruppo di prova
    public InitialSearchAndChatViewControllerInterf2(){
        pageswitch = new PageMenu();
    }

    @FXML
    protected void visit(ActionEvent event) {
        //parte di controllo
        pageswitch.switchToHomeChef(event);
    }
    @FXML
    protected void touchChat(ActionEvent event){
        try {
            anchorChat.getChildren().removeAll(anchorChat.getChildren());
            anchorChat.getChildren().add((Node) FXMLLoader.load(HomeChefApplication.class.getResource("chatuser/chatVoid.fxml")));
        } catch (IOException e) {
            anchorChat.getChildren().removeAll(anchorChat.getChildren());
        }
    }
    @FXML
    protected void searchMessage(){

    }
}
