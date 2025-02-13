package logic.viewcontroller.visithomechef;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import logic.HomeChefApplication;
import logic.appcontroller.VisitHomeChefController;
import logic.homechefutil.HomeChefUtil;
import logic.pageswitch.PageMenu;


import java.io.IOException;

public class VisitHomeChefViewControllerInterf2 extends VisitHomeChefViewController{
    @FXML
    private AnchorPane buttonBar;
    @FXML
    private AnchorPane chefMenu;


    public VisitHomeChefViewControllerInterf2(){
        pageSwitch = new PageMenu();
        controller = new VisitHomeChefController();
    }

    public void initialize(){
        downLoadHcBean();
        HomeChefUtil.linkButtonBarInterf2(buttonBar);
    }

    @FXML
    @Override
    protected void goToChefChat(ActionEvent event){
        launchController();
        try {
            chefMenu.getChildren().removeAll(chefMenu.getChildren());
            chefMenu.getChildren().add((Node) FXMLLoader.load(HomeChefApplication.class.getResource("chatuser/chatVoid.fxml")));
        } catch (IOException e) {
            chefMenu.getChildren().removeAll(chefMenu.getChildren());
        }
    }

    @FXML
    @Override
    protected void goToBookChef(ActionEvent event){
        try {
            chefMenu.getChildren().removeAll(chefMenu.getChildren());
            chefMenu.getChildren().add((Node) FXMLLoader.load(HomeChefApplication.class.getResource("clientbook/interf2.fxml")));
        } catch (IOException e) {
            chefMenu.getChildren().removeAll(chefMenu.getChildren());
        }

    }

    @FXML
    protected void backTo(){
        pageSwitch.backTo();
    }

}
