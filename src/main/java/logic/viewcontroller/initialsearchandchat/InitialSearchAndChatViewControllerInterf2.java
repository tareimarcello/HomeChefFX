package logic.viewcontroller.initialsearchandchat;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import logic.HomeChefApplication;
import logic.beans.ISCBean;
import logic.homechefutil.HomeChefUtil;
import logic.pageswitch.PageMenu;
import logic.patterns.ViewSetter;

import java.io.IOException;
import java.util.HashMap;

public class InitialSearchAndChatViewControllerInterf2 extends InitialSearchAndChatViewController{
    @FXML
    private AnchorPane anchorChat;

    @FXML
    private AnchorPane buttonBar;

    //vedere bene come fa apparire la lista degli utenti, messo un solo gruppo di prova
    public InitialSearchAndChatViewControllerInterf2(){

            pageswitch = new PageMenu();
            iscBeanMap = new HashMap<>();
            subGroupMap = new HashMap<>();
            chatList = ViewSetter.getInstance().getChatList();
            g1Index=7;         //indici da rivedere perchè non sono giusti
            g2Index=8;
            g3Index=9;
            g4Index=10;
            this.lastIndexChat=0;
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
        HomeChefUtil.resetGroupOpacity(this.anchorPane,this.g1Index,this.g2Index,this.g3Index,this.g4Index);
        this.setNextFourChat();
    }

    @FXML
    protected void visit(ActionEvent event) {
        //parte di controllo
        pageswitch.switchTo("visithomepagechef/interf2.fxml",event,"Visit");
    }
    @FXML
    protected void touchChat(ActionEvent event){
        Button clicked = (Button)event.getSource();
        Group parent = (Group) clicked.getParent();
        ISCBean selected = this.iscBeanMap.get(parent.getId());
        ViewSetter.getInstance().setOpenChat(selected);
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
