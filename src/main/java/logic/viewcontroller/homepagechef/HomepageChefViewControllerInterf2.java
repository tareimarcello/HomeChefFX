package logic.viewcontroller.homepagechef;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import logic.HomeChefApplication;
import logic.pageswitch.PageMenu;

import java.io.IOException;

public class HomepageChefViewControllerInterf2 {
    private PageMenu pageswitch;
    @FXML
    private AnchorPane buttonBar;
    @FXML
    private TextField name;
    @FXML
    private TextField dish;
    @FXML
    private TextField res;

    public HomepageChefViewControllerInterf2() {
        pageswitch = new PageMenu();
    }
    public void initialize(){
        try {
            buttonBar.getChildren().removeAll(buttonBar.getChildren());
            buttonBar.getChildren().add((Node) FXMLLoader.load(HomeChefApplication.class.getResource("buttonBarChefInterf2.fxml")));
        } catch (IOException e) {
            buttonBar.getChildren().removeAll(buttonBar.getChildren());
        }
    }

}
