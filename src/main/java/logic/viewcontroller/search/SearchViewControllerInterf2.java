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
import logic.exceptions.NoResultFoundException;
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
        errMsg.setOpacity(0.0);
        SearchBean searchBean = setBean();

        /* Invocazione back end recupero lista chef */


        try {
            controller.searchChefList(searchBean);
            resultVisit.getChildren().removeAll(resultVisit.getChildren());
            resultVisit.getChildren().add((Node) FXMLLoader.load(HomeChefApplication.class.getResource("resultsearch/interf2.fxml")));
            resultVisit.getChildren().removeAll(resultVisit.getChildren());
        } catch (ConnectionException e) {
            Exceptions.exceptionConnectionOccurred();
        }catch(NoResultFoundException ex){
            errMsg.setOpacity(1.0);
            errMsg.setText(ex.getMessage());
        } catch (IOException e) {
            resultVisit.getChildren().removeAll(resultVisit.getChildren());
        }
    }

}
