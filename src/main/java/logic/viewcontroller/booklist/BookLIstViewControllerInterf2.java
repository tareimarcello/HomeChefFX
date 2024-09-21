package logic.viewcontroller.booklist;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import logic.HomeChefApplication;

import java.io.IOException;

public class BookLIstViewControllerInterf2 {
    @FXML
    private AnchorPane buttonBar;
    @FXML
    private Group group1;
    @FXML
    private Group group2;
    @FXML
    private Group group3;
    @FXML
    private Group group4;
    @FXML
    private Group group5;
    @FXML
    private Group group6;
    @FXML
    private Group group7;
    @FXML
    private Group group8;

    public void initialize(){
        try {
            buttonBar.getChildren().removeAll(buttonBar.getChildren());
            buttonBar.getChildren().add((Node) FXMLLoader.load(HomeChefApplication.class.getResource("buttonBarInterf2.fxml")));
        } catch (IOException e) {
            buttonBar.getChildren().removeAll(buttonBar.getChildren());
        }
    }
    @FXML
    protected void outputVal(){

    }
    @FXML
    protected void acceptBook(){

    }
    @FXML
    protected void refBook(){

    }
}
