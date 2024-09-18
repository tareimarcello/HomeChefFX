package logic.viewcontroller.visithomechef;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import logic.HomeChefApplication;
import logic.pageswitch.PageMenu;

import java.io.IOException;

public class VisitHomeChefViewControllerInterf2 {
    private PageMenu pageswitch;
    @FXML
    private TextField chefName;
    @FXML
    private TextField resName;
    @FXML
    private TextField dishName;
    @FXML
    private Slider ratingSL;
    @FXML
    private AnchorPane buttonBar;
    @FXML
    private AnchorPane chefMenu;

    public VisitHomeChefViewControllerInterf2(){
        pageswitch = new PageMenu();
    }

    public void initialize(){
        try {
            buttonBar.getChildren().removeAll(buttonBar.getChildren());
            buttonBar.getChildren().add((Node) FXMLLoader.load(HomeChefApplication.class.getResource("buttonBarInterf2.fxml")));
        } catch (IOException e) {
            buttonBar.getChildren().removeAll(buttonBar.getChildren());
        }
    }

    @FXML
    protected void chat(){
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
    protected void goToRat(){

    }

    @FXML
    protected void backTo(){
        pageswitch.backTo();
    }

}
