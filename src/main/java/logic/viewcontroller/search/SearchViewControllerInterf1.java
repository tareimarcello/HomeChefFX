package logic.viewcontroller.search;

import logic.appcontroller.BookController;
import logic.appcontroller.ISCController;
import logic.appcontroller.SearchController;
import logic.beans.SearchBean;
import logic.exceptions.ConnectionException;
import logic.exceptions.Exceptions;
import logic.exceptions.NoResultFoundException;
import logic.pageswitch.PageMenu;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import logic.patterns.ViewSetter;

public class SearchViewControllerInterf1 extends SearchViewController{
    private PageMenu pageSwitch;

    public SearchViewControllerInterf1(){
        pageSwitch=new PageMenu();
    }

    @FXML
    protected void goToISC(ActionEvent event){
        pageSwitch.switchToISCUser(event);
    }
    @FXML
    protected void goToBook(ActionEvent event){

        pageSwitch.switchToBookList(event);
    }
    @FXML
    protected void goToHome(ActionEvent event){
        pageSwitch.switchToHome(event);
    }

    @FXML
    protected void search(ActionEvent event){
        errMsg.setOpacity(0.0);
        SearchBean searchBean = setBean();

        /* Invocazione back end recupero lista chef */


        try {
            controller.searchChefList(searchBean);
            pageSwitch.switchTo("resultsearch/interf1.fxml",event,"ResultSearch");
        } catch (ConnectionException e) {
           Exceptions.exceptionConnectionOccurred();
        }catch(NoResultFoundException ex){
            errMsg.setOpacity(1.0);
            errMsg.setText(ex.getMessage());
        }
    }

    @FXML
    protected void goToSettings(ActionEvent event){
        pageSwitch.switchToSettings(event);
    }

}
