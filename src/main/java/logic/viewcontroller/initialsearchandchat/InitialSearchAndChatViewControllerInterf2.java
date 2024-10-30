package logic.viewcontroller.initialsearchandchat;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import logic.HomeChefApplication;
import logic.pageswitch.PageMenu;

import java.io.IOException;

public class InitialSearchAndChatViewControllerInterf2 extends InitialSearchAndChatViewController{

    @FXML
    private AnchorPane anchorChat;

    @FXML
    private AnchorPane buttonBar;

    //vedere bene come fa apparire la lista degli utenti, messo un solo gruppo di prova
    public InitialSearchAndChatViewControllerInterf2(){
        pageswitch = new PageMenu();
    }


    public void initialize(){

        subGroupMap.put(0,this.group1);
        subGroupMap.put(1,this.group2);
        subGroupMap.put(2,this.group3);
        subGroupMap.put(3,this.group4);

        try {
            buttonBar.getChildren().removeAll(buttonBar.getChildren());
            buttonBar.getChildren().add((Node) FXMLLoader.load(HomeChefApplication.class.getResource("buttonBarInterf2.fxml")));
        } catch (IOException e) {
            buttonBar.getChildren().removeAll(buttonBar.getChildren());
        }
    }

    @FXML
    protected void visit(ActionEvent event) {
        //parte di controllo
        pageswitch.switchTo("visithomepagechef/interf2.fxml",event,"Visit");
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
        //to be implemented
    }
    @FXML
    protected void touchChatChef(ActionEvent event){
        try {
            anchorChat.getChildren().removeAll(anchorChat.getChildren());
            anchorChat.getChildren().add((Node) FXMLLoader.load(HomeChefApplication.class.getResource("chatchef/chatVoid.fxml")));
        } catch (IOException e) {
            anchorChat.getChildren().removeAll(anchorChat.getChildren());
        }
    }

}
