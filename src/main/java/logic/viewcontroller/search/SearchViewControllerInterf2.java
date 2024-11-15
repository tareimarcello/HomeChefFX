package logic.viewcontroller.search;

import logic.HomeChefApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import logic.appcontroller.SearchController;
import logic.beans.SearchBean;
import logic.exceptions.ConnectionException;
import logic.exceptions.Exceptions;
import logic.homechefutil.HomeChefUtil;

import java.io.IOException;

public class SearchViewControllerInterf2 extends SearchViewController{
    @FXML
    private AnchorPane buttonBar;
    @FXML
    private AnchorPane resultVisit;

    public void initialize(){
        HomeChefUtil.linkButtonBarInterf2(buttonBar);
    }
    @FXML
    protected void search(){
        SearchBean searchBean = setBean();

        /* Invocazione back end recupero lista chef */

        SearchController controller = new SearchController();

        try {
            controller.searchChefList(searchBean);
        } catch (ConnectionException e) {
            Exceptions.exceptionConnectionOccurred();
        }
        try {
            resultVisit.getChildren().removeAll(resultVisit.getChildren());
            resultVisit.getChildren().add((Node) FXMLLoader.load(HomeChefApplication.class.getResource("resultsearch/interf2.fxml")));
        } catch (IOException e) {
            resultVisit.getChildren().removeAll(resultVisit.getChildren());
        }
    }

}
