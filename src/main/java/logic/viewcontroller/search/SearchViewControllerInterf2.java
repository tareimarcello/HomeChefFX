package logic.viewcontroller.search;

import logic.HomeChefApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class SearchViewControllerInterf2 {
    @FXML
    private AnchorPane buttonBar;
    @FXML
    private AnchorPane resultVisit;
    @FXML
    private TextField eatName;
    @FXML
    private TextField chefName;

    public void initialize(){
        try {
            buttonBar.getChildren().removeAll(buttonBar.getChildren());
            buttonBar.getChildren().add((Node) FXMLLoader.load(HomeChefApplication.class.getResource("buttonBarInterf2.fxml")));
        } catch (IOException e) {
            buttonBar.getChildren().removeAll(buttonBar.getChildren());
        }
    }
    @FXML
    protected void search(){
        try {
            resultVisit.getChildren().removeAll(resultVisit.getChildren());
            resultVisit.getChildren().add((Node) FXMLLoader.load(HomeChefApplication.class.getResource("resultsearch/interf2.fxml")));
        } catch (IOException e) {
            resultVisit.getChildren().removeAll(resultVisit.getChildren());
        }
    }

}
