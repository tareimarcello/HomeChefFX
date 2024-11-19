package logic.viewcontroller.visithomechef;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import logic.HomeChefApplication;
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
    }

    public void initialize(){
        downLoadHcBean();
        HomeChefUtil.linkButtonBarInterf2(buttonBar);
    }

    @FXML
    protected void chat(){
        launchController();
        try {
            chefMenu.getChildren().removeAll(chefMenu.getChildren());
            chefMenu.getChildren().add((Node) FXMLLoader.load(HomeChefApplication.class.getResource("chatuser/chatVoid.fxml")));
        } catch (IOException e) {
            chefMenu.getChildren().removeAll(chefMenu.getChildren());
        }
    }

    @FXML
    protected void goToChefCalendarBook(){
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
